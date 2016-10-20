package by.epam.kinorating.command.admin;

import by.epam.kinorating.command.Command;
import by.epam.kinorating.constant.Attribute;
import by.epam.kinorating.constant.Message;
import by.epam.kinorating.constant.PagePath;
import by.epam.kinorating.constant.Parameter;
import by.epam.kinorating.exception.ServiceException;
import by.epam.kinorating.manager.MessageManager;
import by.epam.kinorating.service.GenreService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Диана и Глеб on 06.09.2016.
 */
public class DelGenreCommand implements Command {
    private final Logger LOG = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String locale = (String) session.getAttribute(Attribute.ATTRIBUTE_LOCALE);

        long genreId = Long.valueOf(request.getParameter(Parameter.PARAMETER_FILM_GENRE_ID));
        try {
            GenreService.delById(genreId);
        } catch (ServiceException e) {
            LOG.error("Exception " + e.getMessage());
            String errmessage = MessageManager.getMessage(Message.MESSAGE_DEL_GENRE, locale);
            request.setAttribute(Attribute.ATTRIBUTE_ERR_MESSAGE, errmessage);
            return PagePath.PAGE_INFO;
        }
        return "controller?command=searchallgenres";
    }
}
