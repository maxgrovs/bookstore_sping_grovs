package by.grovs.controller.command.impl;

import by.grovs.controller.command.SpringCommand;
import by.grovs.entity.Book;
import by.grovs.service.BookService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;


@Component("update_book")
public class UpdateBookCommand implements SpringCommand {

    private final BookService bookService;

    public UpdateBookCommand(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public String execute(HttpServletRequest request) {


        Long id = Long.parseLong(request.getParameter("id"));
        Book book = bookService.getById(id);
        book.setName(request.getParameter("name"));

        Book updated = bookService.editBook(book);
        request.setAttribute("book", updated);
        request.setAttribute("message", "User has been updated!");

        return "WEB-INF/jsp/one-book.jsp";


    }
}