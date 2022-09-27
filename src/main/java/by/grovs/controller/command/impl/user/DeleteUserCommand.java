package by.grovs.controller.command.impl.user;

import by.grovs.controller.command.SpringCommand;
import by.grovs.service.BookService;
import by.grovs.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component("delete_user")
public class DeleteUserCommand implements SpringCommand {

    private final UserService userService;

    @Override
    public String execute(HttpServletRequest request) {


        Long id = Long.parseLong(request.getParameter("id"));

        userService.delete(id);
        request.setAttribute("message", "User has been deleted!");

        return "WEB-INF/jsp/main.jsp";


    }
}