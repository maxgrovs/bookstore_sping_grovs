package by.grovs.controller.spring_command.impl;

import by.grovs.controller.spring_command.SpringCommand;
import by.grovs.entity.Book;
import by.grovs.service.BookService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("books")
public class BooksSpringCommand implements SpringCommand {

    private final BookService bookService;

    public BooksSpringCommand(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public String execute(HttpServletRequest request)  {

        List<Book> books = bookService.getAll();

        request.setAttribute("books", books);

        return "WEB-INF/jsp/books.jsp";

    }
}