package by.epam.kinorating.command.film;

import by.epam.kinorating.command.Command;
import by.epam.kinorating.constant.Attribute;
import by.epam.kinorating.constant.Message;
import by.epam.kinorating.constant.PagePath;
import by.epam.kinorating.constant.Parameter;
import by.epam.kinorating.entity.Comment;
import by.epam.kinorating.entity.Film;
import by.epam.kinorating.exception.ServiceException;
import by.epam.kinorating.manager.MessageManager;
import by.epam.kinorating.service.CommentService;
import by.epam.kinorating.service.FilmService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Диана и Глеб on 26.08.2016.
 */
public class SearchByTitleCommand implements Command {
    private final Logger LOG = LogManager.getLogger();
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String title = request.getParameter(Parameter.PARAMETER_FILM_TITLE);
        String locale = (String) session.getAttribute(Attribute.ATTRIBUTE_LOCALE);
        Film film;
        try {
            film = FilmService.getByName(title);
        } catch (ServiceException e) {
            LOG.error("Exception while getting film by title " + e.getMessage());
            String errmessage = MessageManager.getMessage(Message.MESSAGE_FILM_NOT_FOUND, locale);
            request.setAttribute(Attribute.ATTRIBUTE_ERR_MESSAGE, errmessage);
            return PagePath.PAGE_INFO;
        }
        session.setAttribute(Attribute.ATTRIBUTE_FILM, film);

        List<Comment> comments = null;
        try {
            comments = CommentService.findCommentsByFilmId(film.getFilmId());
        } catch (ServiceException e) {
            LOG.error("Exception while getting comments " + e.getMessage());
        }
        session.setAttribute(Attribute.ATTRIBUTE_COMMENTS, comments);
        String page = PagePath.PAGE_FILM;
        session.setAttribute(Attribute.ATTRIBUTE_PAGE, page);
        return page;
    }
}
