package by.epam.kinorating.command.admin;

import by.epam.kinorating.command.Command;
import by.epam.kinorating.constant.Attribute;
import by.epam.kinorating.constant.Message;
import by.epam.kinorating.constant.PagePath;
import by.epam.kinorating.constant.Parameter;
import by.epam.kinorating.entity.Comment;
import by.epam.kinorating.exception.ServiceException;
import by.epam.kinorating.manager.MessageManager;
import by.epam.kinorating.service.CommentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Диана и Глеб on 01.09.2016.
 */
public class GoToEditCommentCommand implements Command {
    private final Logger LOG = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String locale = (String) session.getAttribute(Attribute.ATTRIBUTE_LOCALE);
        Comment comment;
        try {
            long commentId = Long.valueOf(request.getParameter(Parameter.PARAMETER_COMMENT_ID));
            comment = CommentService.findCommentById(commentId);
        } catch (ServiceException e) {
            LOG.error("Exception " + e.getMessage());
            String errmessage = MessageManager.getMessage(Message.MESSAGE_ERROR, locale);
            request.setAttribute(Attribute.ATTRIBUTE_ERR_MESSAGE, errmessage);
            return PagePath.PAGE_INFO;
        } catch (NumberFormatException e ) {
            LOG.error("Exception while parsing comment ID " + e.getMessage());
            String errmessage = MessageManager.getMessage(Message.MESSAGE_NO_SUCH_ID, locale);
            request.setAttribute(Attribute.ATTRIBUTE_ERR_MESSAGE, errmessage);
            return PagePath.PAGE_INFO;
        }
        session.setAttribute(Attribute.ATTRIBUTE_COMMENT, comment);
        String page = PagePath.PAGE_EDIT_COMMENT;
        session.setAttribute(Attribute.ATTRIBUTE_PAGE, page);
        return page;
    }
}
