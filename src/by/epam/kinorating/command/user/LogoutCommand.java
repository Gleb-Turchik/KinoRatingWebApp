package by.epam.kinorating.command.user;

import by.epam.kinorating.command.Command;
import by.epam.kinorating.constant.PagePath;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Диана и Глеб on 06.08.2016.
 */
public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().invalidate();
        return PagePath.PAGE_INDEX;
    }
}
