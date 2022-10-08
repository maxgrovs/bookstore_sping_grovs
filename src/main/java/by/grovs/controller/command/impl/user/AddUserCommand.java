package by.grovs.controller.command.impl.user;

import by.grovs.controller.command.SpringCommand;
import by.grovs.entity.Book;
import by.grovs.entity.User;
import by.grovs.service.BookService;
import by.grovs.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component("add_user")
public class AddUserCommand implements SpringCommand {

    private final UserService userService;

    @Override
    public String execute(HttpServletRequest request) {

        User user = new User();

        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));

        User addUser = userService.create(user);

        System.out.println();
        request.setAttribute("user", addUser);
        request.setAttribute("message", "User has been added!");

        return "WEB-INF/jsp/one-user.jsp";


    }
}