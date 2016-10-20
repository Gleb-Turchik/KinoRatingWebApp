package by.epam.kinorating.command.admin;

import by.epam.kinorating.command.Command;
import by.epam.kinorating.constant.Attribute;
import by.epam.kinorating.constant.Message;
import by.epam.kinorating.constant.PagePath;
import by.epam.kinorating.entity.Country;
import by.epam.kinorating.exception.ServiceException;
import by.epam.kinorating.manager.MessageManager;
import by.epam.kinorating.service.CountryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Диана и Глеб on 06.09.2016.
 */
public class SearchAllCountrieCommand implements Command {
    private final Logger LOG = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String locale = (String) session.getAttribute(Attribute.ATTRIBUTE_LOCALE);
        List<Country> list = null;
        try {
            list = CountryService.findAllCountries();
        } catch (ServiceException e) {
            LOG.error("Exception occurred while getting countries from db " + e.getMessage());
            String errmessage = MessageManager.getMessage(Message.MESSAGE_COUNTRY_LIST, locale);
            request.setAttribute(Attribute.ATTRIBUTE_ERR_MESSAGE, errmessage);
            return PagePath.PAGE_INFO;
        }
        request.setAttribute(Attribute.ATTRIBUTE_COUNTRIES, list);
        String page = PagePath.PAGE_ADMIN_LIST;
        session.setAttribute(Attribute.ATTRIBUTE_PAGE, page);
        return page;
    }
}
