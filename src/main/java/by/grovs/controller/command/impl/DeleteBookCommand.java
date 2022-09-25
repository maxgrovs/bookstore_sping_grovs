package by.grovs.controller.command.impl;

import by.grovs.controller.command.SpringCommand;
import by.grovs.entity.Book;
import by.grovs.service.BookService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;


@Component("delete_book")
public class DeleteBookCommand implements SpringCommand {

    private final BookService bookService;


    public DeleteBookCommand(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public String execute(HttpServletRequest request) {


        Long id = Long.parseLong(request.getParameter("id"));

        bookService.delete(id);
        request.setAttribute("message", "Book has been deleted!");

        return "WEB-INF/jsp/main.jsp";


    }
}