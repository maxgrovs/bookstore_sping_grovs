package by.grovs.controller.command.impl;

import by.grovs.controller.command.SpringCommand;
import by.grovs.entity.Book;
import by.grovs.service.BookService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("books")
public class BooksCommand implements SpringCommand {

    private final BookService bookService;

    public BooksCommand(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public String execute(HttpServletRequest request)  {

        List<Book> books = bookService.getAll();

        request.setAttribute("books", books);

        return "WEB-INF/jsp/books.jsp";

    }
}