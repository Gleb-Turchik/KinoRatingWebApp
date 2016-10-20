package by.epam.kinorating.command.admin;

import by.epam.kinorating.command.Command;
import by.epam.kinorating.constant.Attribute;
import by.epam.kinorating.constant.Message;
import by.epam.kinorating.constant.PagePath;
import by.epam.kinorating.constant.Parameter;
import by.epam.kinorating.entity.Country;
import by.epam.kinorating.entity.Film;
import by.epam.kinorating.entity.Genre;
import by.epam.kinorating.exception.ServiceException;
import by.epam.kinorating.manager.MessageManager;
import by.epam.kinorating.service.FilmService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Диана и Глеб on 28.08.2016.
 */
public class EditFilmCommand implements Command {
    private final Logger LOG = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String locale = (String) session.getAttribute(Attribute.ATTRIBUTE_LOCALE);

        long filmID = Long.valueOf(request.getParameter(Parameter.PARAMETER_FILM_ID));
        String title = request.getParameter(Parameter.PARAMETER_FILM_TITLE);
        int year = Integer.valueOf(request.getParameter(Parameter.PARAMETER_FILM_YEAR));
        long genreId = Long.valueOf(request.getParameter(Parameter.PARAMETER_FILM_GENRE));
        int duration = Integer.valueOf(request.getParameter(Parameter.PARAMETER_FILM_DURATION));
        long countryId = Long.valueOf(request.getParameter(Parameter.PARAMETER_FILM_COUNTRY));
        String director = request.getParameter(Parameter.PARAMETER_FILM_DIRECTOR);
        String actor = request.getParameter(Parameter.PARAMETER_FILM_ACTOR);
        String details = request.getParameter(Parameter.PARAMETER_FILM_DETAILS);
        String trailer = request.getParameter(Parameter.PARAMETER_FILM_TRAILER);

        Genre genre = new Genre(genreId);
        Country country = new Country(countryId);
        Film film = new Film(filmID, title, year, genre, duration, country, director, actor, details, trailer);

        try {
            FilmService.editFilm(film);
        } catch (ServiceException e) {
            LOG.error("Exception " + e.getMessage());
            String errmessage = MessageManager.getMessage(Message.MESSAGE_FILM_EDIT, locale);
            request.setAttribute(Attribute.ATTRIBUTE_ERR_MESSAGE, errmessage);
            return PagePath.PAGE_INFO;
        }
        return "controller?command=getfilm&filmID=" + filmID;
    }
}
