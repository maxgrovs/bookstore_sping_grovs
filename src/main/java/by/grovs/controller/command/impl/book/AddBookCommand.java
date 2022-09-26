package by.grovs.controller.command.impl.book;

import by.grovs.controller.command.SpringCommand;
import by.grovs.entity.Book;
import by.grovs.service.BookService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;


@Component("add_book")
public class AddBookCommand implements SpringCommand {

    private final BookService bookService;


    public AddBookCommand(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        Book book = new Book();

        book.setName(request.getParameter("title"));
        book.setAuthor(request.getParameter("author"));

        Book addBook = bookService.addBook(book);

        request.setAttribute("book", addBook);
        request.setAttribute("message", "Book has been added!");

        return "WEB-INF/jsp/books.jsp";


    }
}