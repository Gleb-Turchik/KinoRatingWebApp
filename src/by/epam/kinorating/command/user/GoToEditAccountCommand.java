package by.epam.kinorating.command.user;

import by.epam.kinorating.command.Command;
import by.epam.kinorating.constant.Attribute;
import by.epam.kinorating.constant.PagePath;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Диана и Глеб on 05.09.2016.
 */
public class GoToEditAccountCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.PAGE_EDIT_ACCOUNT;
        request.getSession().setAttribute(Attribute.ATTRIBUTE_PAGE, page);
        return page;
    }
}
