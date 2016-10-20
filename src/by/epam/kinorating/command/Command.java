package by.epam.kinorating.command;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Диана и Глеб on 06.08.2016.
 */
public interface Command {
    String execute(HttpServletRequest request);
}
