package by.epam.kinorating.command.user;

import by.epam.kinorating.command.Command;
import by.epam.kinorating.constant.Attribute;
import by.epam.kinorating.constant.Message;
import by.epam.kinorating.constant.PagePath;
import by.epam.kinorating.constant.Parameter;
import by.epam.kinorating.entity.User;
import by.epam.kinorating.exception.ServiceException;
import by.epam.kinorating.service.UserService;
import by.epam.kinorating.manager.MessageManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Диана и Глеб on 06.08.2016.
 */
public class LoginCommand implements Command {
    private final Logger LOG = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String email = request.getParameter(Parameter.PARAMETER_USER_EMAIL);
        String password = request.getParameter(Parameter.PARAMETER_USER_PASSWORD);
        String locale = (String) session.getAttribute(Attribute.ATTRIBUTE_LOCALE);
        String errmessage = MessageManager.getMessage(Message.MESSAGE_LOGIN_PASS_ERROR, locale);
        String page;
        try {
            if (email != null && !email.isEmpty() && password != null && !password.isEmpty()) {
                if (UserService.checkUser(email, password)) {
                    User user = UserService.getUser(email, password);
                    session.setAttribute(Attribute.ATTRIBUTE_USER, user);
                    page = (String) session.getAttribute(Attribute.ATTRIBUTE_PAGE);
                    return page;
                } else {
                    request.setAttribute(Attribute.ATTRIBUTE_ERR_MESSAGE, errmessage);
                }
            } else {
            request.setAttribute(Attribute.ATTRIBUTE_ERR_MESSAGE, errmessage);
            }
        } catch (ServiceException e) {
            LOG.error("Exception occurred in Login command " + e.getMessage());
            errmessage = MessageManager.getMessage(Message.MESSAGE_ERROR, locale);
            request.setAttribute(Attribute.ATTRIBUTE_ERR_MESSAGE, errmessage);
            return PagePath.PAGE_INFO;
        }
        page = PagePath.PAGE_LOGIN;
        request.getSession().setAttribute(Attribute.ATTRIBUTE_PAGE, page);
        return page;
    }
}
