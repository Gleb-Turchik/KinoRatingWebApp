package by.epam.kinorating.command.admin;

import by.epam.kinorating.command.Command;
import by.epam.kinorating.constant.Attribute;
import by.epam.kinorating.constant.PagePath;
import by.epam.kinorating.entity.User;
import by.epam.kinorating.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Диана и Глеб on 01.09.2016.
 */
public class GoToAdminAccountCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Attribute.ATTRIBUTE_USER);
        UserService.isAdmin(user);
        String page = PagePath.PAGE_ADMIN_ACCOUNT;
        request.getSession().setAttribute(Attribute.ATTRIBUTE_PAGE, page);
        return page;
    }
}
