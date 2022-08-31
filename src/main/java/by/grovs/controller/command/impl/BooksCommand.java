package by.grovs.controller.command.impl;

import by.grovs.service.BookService;
import by.grovs.service.impl.BookServiceImpl;
import by.grovs.entity.Book;
import by.grovs.controller.command.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;


public class BooksCommand implements Command {


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Book> books = BookServiceImpl.getInstance().getAll();

        request.setAttribute("books", books);
        request.getRequestDispatcher("WEB-INF/jsp/books.jsp").forward(request, response);
    }
}