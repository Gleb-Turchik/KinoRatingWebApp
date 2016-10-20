package by.epam.kinorating.command.film;

import by.epam.kinorating.command.Command;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Created by Диана и Глеб on 09.09.2016.
 */
public class RatingCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()) {
            String s = names.nextElement();
            System.out.print(s + " ");
            String[] ss = request.getParameterValues(s);
            for (String sss : ss) {
                System.out.print(sss + " ");
            }
            System.out.println();
        }
        return "{\"msg\":\"ok\"}";
    }
}
