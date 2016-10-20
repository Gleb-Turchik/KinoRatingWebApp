package by.epam.kinorating.command;

import by.epam.kinorating.constant.Attribute;
import by.epam.kinorating.constant.PagePath;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Диана и Глеб on 06.08.2016.
 */

public class EmptyCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().setAttribute(Attribute.ATTRIBUTE_PAGE, PagePath.PAGE_MAIN);
        return PagePath.PAGE_INDEX;
    }
}
