package by.epam.kinorating.command.user;

import by.epam.kinorating.command.Command;
import by.epam.kinorating.constant.Attribute;
import by.epam.kinorating.constant.Message;
import by.epam.kinorating.constant.PagePath;
import by.epam.kinorating.constant.Parameter;
import by.epam.kinorating.entity.Role;
import by.epam.kinorating.entity.User;
import by.epam.kinorating.exception.ServiceException;
import by.epam.kinorating.manager.MessageManager;
import by.epam.kinorating.service.RegisterService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Диана и Глеб on 20.08.2016.
 */
public class RegistrationCommand implements Command {
    private final Logger LOG = LogManager.getLogger();
    @Override
    public String execute(HttpServletRequest request) {
        User  user = new User();
        user.setName(request.getParameter(Parameter.PARAMETER_USER_NAME).trim());
        user.setSurname(request.getParameter(Parameter.PARAMETER_USER_SURNAME).trim());
        user.setEmail(request.getParameter(Parameter.PARAMETER_USER_EMAIL).trim());
        user.setPassword(request.getParameter(Parameter.PARAMETER_USER_PASSWORD).trim());
        user.setBan(false);
        Role role = new Role();
        role.setRoleId(2);
        user.setRole(role);
        String locale = (String) request.getSession().getAttribute(Attribute.ATTRIBUTE_LOCALE);

        String msg = RegisterService.checkFields(user, locale);
        if (msg == null) {
            try {
                msg = RegisterService.addUser(user, locale);
            } catch (ServiceException e) {
                LOG.error("Exception occurred in registration command" + e.getMessage());
                String errmessage = MessageManager.getMessage(Message.MESSAGE_ERROR, locale);
                request.setAttribute(Attribute.ATTRIBUTE_ERR_MESSAGE, errmessage);
                return PagePath.PAGE_INFO;
            }
        } request.setAttribute(Attribute.ATTRIBUTE_ERR_MESSAGE, msg);
        return PagePath.PAGE_REGISTRATION;
    }
}
