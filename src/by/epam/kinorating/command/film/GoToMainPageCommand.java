package by.epam.kinorating.command.film;

import by.epam.kinorating.command.Command;
import by.epam.kinorating.constant.Attribute;
import by.epam.kinorating.constant.PagePath;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Диана и Глеб on 01.09.2016.
 */
public class GoToMainPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.PAGE_MAIN;
        request.getSession().setAttribute(Attribute.ATTRIBUTE_PAGE, page);
        return page;
    }
}
