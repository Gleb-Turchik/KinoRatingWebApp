package by.epam.kinorating.listener;

import by.epam.kinorating.constant.Attribute;
import by.epam.kinorating.constant.PagePath;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by Диана и Глеб on 06.08.2016.
 */
@WebListener
public class LangListenerImpl implements HttpSessionListener {
    private static final String DEFAULT_LOC = "ru_RU";
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        httpSessionEvent.getSession().setAttribute(Attribute.ATTRIBUTE_LOCALE, DEFAULT_LOC);
        String page = PagePath.PAGE_MAIN;
        httpSessionEvent.getSession().setAttribute(Attribute.ATTRIBUTE_PAGE, page);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
