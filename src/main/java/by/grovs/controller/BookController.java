package by.grovs.controller;

import by.grovs.controller.command.Command;
import by.grovs.controller.command.impl.CommandFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;


@WebServlet("/book-store")
public class BookController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String commandParam = request.getParameter("command");

        Command command = CommandFactory.INSTANCE.getCommand(commandParam);

      //  request.getRequestDispatcher("WEB-INF/jsp/grovs.jsp").forward(request, response);

        if (commandParam != null) {
            command.execute(request, response);
        } else {
            request.getRequestDispatcher("WEB-INF/jsp/main.jsp").forward(request, response);
        }


    }


}