package by.epam.kinorating.command.comment;

import by.epam.kinorating.command.Command;
import by.epam.kinorating.constant.Attribute;
import by.epam.kinorating.constant.Message;
import by.epam.kinorating.constant.PagePath;
import by.epam.kinorating.constant.Parameter;
import by.epam.kinorating.entity.User;
import by.epam.kinorating.exception.ServiceException;
import by.epam.kinorating.manager.MessageManager;
import by.epam.kinorating.service.CommentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Диана и Глеб on 21.08.2016.
 */
public class AddCommentCommand implements Command {
    private final Logger LOG = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String locale = (String) session.getAttribute(Attribute.ATTRIBUTE_LOCALE);

        String text = request.getParameter(Parameter.PARAMETER_COMMENT_TEXT);
        Long filmID;

        User user = (User) session.getAttribute(Attribute.ATTRIBUTE_USER);
        Long userID = user.getUserId();

        try {
            filmID = Long.valueOf(request.getParameter(Parameter.PARAMETER_FILM_ID));
            CommentService.addComment(filmID, userID, text);
        } catch (ServiceException | NumberFormatException e) {
            LOG.error("Exception occurred while comment adding " + e.getMessage());
            String errmessage = MessageManager.getMessage(Message.MESSAGE_COMMENT_ADDING_ERROR, locale);
            request.setAttribute(Attribute.ATTRIBUTE_ERR_MESSAGE, errmessage);
            return PagePath.PAGE_INFO;
        }
        return "controller?command=getfilm&filmID="+filmID;
    }
}
