/*
package by.epam.kinorating.filter;

import by.epam.kinorating.entity.Role;
import by.epam.kinorating.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

*/
/**
 * Created by Диана и Глеб on 06.09.2016.
 *//*

@WebFilter(urlPatterns = { "/controller" }, servletNames = { "MainServlet" })
public class ServletSecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        Role role = user.getRole();
        if (role == null) {
            role.setRoleId(3);
            role.setRole("guest");
            session.setAttribute("role", role);
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("index.jsp");
            dispatcher.forward(req, resp);
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
*/
