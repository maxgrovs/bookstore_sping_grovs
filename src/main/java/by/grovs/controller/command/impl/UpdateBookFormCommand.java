package by.grovs.controller.command.impl;

import by.grovs.controller.command.SpringCommand;
import by.grovs.entity.Book;
import by.grovs.entity.User;
import by.grovs.service.BookService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;


@Component("update-book-form")
public class UpdateBookFormCommand implements SpringCommand {

    private final BookService bookService;

    public UpdateBookFormCommand(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        Long id = Long.parseLong(request.getParameter("id"));
        Book book = bookService.getById(id);

        request.setAttribute("book", book);


        return "WEB-INF/jsp/update-book-form.jsp";


    }
}