package by.epam.kinorating.command.user;

import by.epam.kinorating.command.Command;
import by.epam.kinorating.constant.Attribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Диана и Глеб on 06.08.2016.
 */
public class LanguageCommand implements Command {
    private final static String PARAMETER_LANGUAGE = "lang";
    private final static String EN = "en";
    private final static String RU = "ru";
    private final static String RUS_LOCALE = "ru_RU";
    private final static String ENG_LOCALE = "en_US";

    @Override
    public String execute(HttpServletRequest request) {
        String language = request.getParameter(PARAMETER_LANGUAGE);
        String page = (String) request.getSession().getAttribute(Attribute.ATTRIBUTE_PAGE);
        HttpSession session = request.getSession();
        switch (language) {
            case EN:
                session.setAttribute(Attribute.ATTRIBUTE_LOCALE, ENG_LOCALE);
                break;
            case RU:
                session.setAttribute(Attribute.ATTRIBUTE_LOCALE, RUS_LOCALE);
                break;
        }
        return page;
    }
}
