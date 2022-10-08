package by.grovs.controller.command.impl.book;

import by.grovs.controller.command.SpringCommand;
import by.grovs.entity.Book;
import by.grovs.service.BookService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;


@Component("book")
public class BookCommand implements SpringCommand {

    private final BookService bookService;

    public BookCommand(BookService bookService) {
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