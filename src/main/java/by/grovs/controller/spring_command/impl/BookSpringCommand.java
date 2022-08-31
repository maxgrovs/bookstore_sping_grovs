package by.grovs.controller.spring_command.impl;

import by.grovs.controller.spring_command.SpringCommand;
import by.grovs.entity.Book;
import by.grovs.entity.User;
import by.grovs.service.BookService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;


@Component("book")
public class BookSpringCommand implements SpringCommand {

    private final BookService bookService;

    public BookSpringCommand(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public String execute(HttpServletRequest request) {


        Long id = Long.parseLong(request.getParameter("id"));
        Book book = bookService.getById(id);
        request.setAttribute("book", book);

        return "WEB-INF/jsp/one-book.jsp";


    }
}