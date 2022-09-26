package by.grovs.controller.command.impl.book;

import by.grovs.controller.command.SpringCommand;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;


@Component("add_book_form")
public class AddBookFormCommand implements SpringCommand {

    @Override
    public String execute(HttpServletRequest request) {

        return "WEB-INF/jsp/add-book-form.jsp";

    }
}