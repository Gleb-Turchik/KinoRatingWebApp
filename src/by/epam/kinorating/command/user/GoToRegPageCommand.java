package by.epam.kinorating.command.user;

import by.epam.kinorating.command.Command;
import by.epam.kinorating.constant.Attribute;
import by.epam.kinorating.constant.PagePath;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Диана и Глеб on 31.08.2016.
 */
public class GoToRegPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.PAGE_REGISTRATION;
        request.getSession().setAttribute(Attribute.ATTRIBUTE_PAGE, page);
        return page;
    }
}
