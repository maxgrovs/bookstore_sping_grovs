package by.grovs.controller;

import by.grovs.SpringConfig;
import by.grovs.controller.command.SpringCommand;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

@WebServlet("/book-store")
public class SpringController extends HttpServlet {

    private AnnotationConfigApplicationContext context;

    @Override
    public void init() throws ServletException {

        context = new AnnotationConfigApplicationContext(SpringConfig.class);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("command");
        SpringCommand command = (SpringCommand) context.getBean(action);
        String page = command.execute(req);
        req.getRequestDispatcher(page).forward(req, resp);

    }

    @Override
    public void destroy() {
        context.close();
    }
}
