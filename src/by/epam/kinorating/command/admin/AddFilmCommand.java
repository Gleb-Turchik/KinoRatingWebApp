package by.epam.kinorating.command.admin;

import by.epam.kinorating.command.Command;
import by.epam.kinorating.constant.Attribute;
import by.epam.kinorating.constant.Message;
import by.epam.kinorating.constant.PagePath;
import by.epam.kinorating.constant.Parameter;
import by.epam.kinorating.entity.Film;
import by.epam.kinorating.exception.ServiceException;
import by.epam.kinorating.manager.MessageManager;
import by.epam.kinorating.service.FilmService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Диана и Глеб on 30.08.2016.
 */
public class AddFilmCommand implements Command {
    private final Logger LOG = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String locale = (String) session.getAttribute(Attribute.ATTRIBUTE_LOCALE);
        String title = request.getParameter(Parameter.PARAMETER_FILM_TITLE);
        int year = Integer.valueOf(request.getParameter(Parameter.PARAMETER_FILM_YEAR));
        long countryId = Long.valueOf(request.getParameter(Parameter.PARAMETER_FILM_COUNTRY));
        long genreId = Long.valueOf(request.getParameter(Parameter.PARAMETER_FILM_GENRE));
        int duration = Integer.valueOf(request.getParameter(Parameter.PARAMETER_FILM_DURATION));
        String details = request.getParameter(Parameter.PARAMETER_FILM_DETAILS);
        String actor = request.getParameter(Parameter.PARAMETER_FILM_ACTOR);
        String director = request.getParameter(Parameter.PARAMETER_FILM_DIRECTOR);
        String trailer = request.getParameter(Parameter.PARAMETER_FILM_TRAILER);
        Film film = new Film(countryId, genreId, title, year, duration, details, director, actor, trailer);
        try {
            FilmService.addFilm(film);
            film = FilmService.getByName(title);
        } catch (ServiceException e) {
            LOG.error("Exception " + e.getMessage());
            String errmessage = MessageManager.getMessage(Message.MESSAGE_ADD_FILM, locale);
            request.setAttribute(Attribute.ATTRIBUTE_ERR_MESSAGE, errmessage);
            return PagePath.PAGE_INFO;
        }
        session.setAttribute(Attribute.ATTRIBUTE_FILM, film);
        session.setAttribute(Attribute.ATTRIBUTE_COMMENTS, null);
        String page = PagePath.PAGE_FILM;
        session.setAttribute(Attribute.ATTRIBUTE_PAGE, page);
        return page;
    }
}
