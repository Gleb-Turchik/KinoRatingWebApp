package by.epam.kinorating.controller;

import by.epam.kinorating.command.ActionFactory;
import by.epam.kinorating.command.Command;
import by.epam.kinorating.constant.Attribute;
import by.epam.kinorating.constant.PagePath;
import by.epam.kinorating.manager.MessageManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by Диана и Глеб on 06.08.2016.
 */
@WebServlet("/controller")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
        maxFileSize=1024*1024*10,               // 10MB
        maxRequestSize=1024*1024*50)            // 50MB
public class Controller extends HttpServlet {

    private static final String COMMAND = "command";
    private static final String MESSAGE_NULL_PAGE = "message.nullpage";


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page;
        HttpSession session = request.getSession();
        Command command = ActionFactory.defineCommand(request.getParameter(COMMAND));
        page = command.execute(request);
        if (page != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else {
            page = PagePath.PAGE_INDEX;
            session.setAttribute(Attribute.ATTRIBUTE_ERR_MESSAGE, MessageManager.getMessage(MESSAGE_NULL_PAGE,
                    (String) session.getAttribute(Attribute.ATTRIBUTE_LOCALE)));
            response.sendRedirect(request.getContextPath() + page);
        }
    }
}
