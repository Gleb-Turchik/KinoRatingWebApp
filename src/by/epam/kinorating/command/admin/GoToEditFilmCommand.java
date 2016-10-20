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
import by.epam.kinorating.service.CountryService;
import by.epam.kinorating.service.FilmService;
import by.epam.kinorating.service.GenreService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Диана и Глеб on 28.08.2016.
 */
public class GoToEditFilmCommand implements Command {
    private final Logger LOG = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String locale = (String) session.getAttribute(Attribute.ATTRIBUTE_LOCALE);
        Film film;
        List<Country> countries;
        List<Genre> genres;
        try {
            long filmId = Long.valueOf(request.getParameter(Parameter.PARAMETER_FILM_ID));
            film = FilmService.getById(filmId);
            countries = CountryService.findAllCountries();
            genres = GenreService.findAll();
        } catch (ServiceException e) {
            LOG.error("Exception " + e.getMessage());
            String errmessage = MessageManager.getMessage(Message.MESSAGE_ERROR, locale);
            request.setAttribute(Attribute.ATTRIBUTE_ERR_MESSAGE, errmessage);
            return PagePath.PAGE_INFO;
        } catch (NumberFormatException e ) {
            LOG.error("Exception while parsing film ID " + e.getMessage());
            String errmessage = MessageManager.getMessage(Message.MESSAGE_NO_SUCH_ID, locale);
            request.setAttribute(Attribute.ATTRIBUTE_ERR_MESSAGE, errmessage);
            return PagePath.PAGE_INFO;
        }
        session.setAttribute(Attribute.ATTRIBUTE_FILM, film);
        request.setAttribute(Attribute.ATTRIBUTE_COUNTRIES, countries);
        request.setAttribute(Attribute.ATTRIBUTE_GENRES, genres);
        String page = PagePath.PAGE_EDIT_FILM;
        session.setAttribute(Attribute.ATTRIBUTE_PAGE, page);
        return page;
    }
}
