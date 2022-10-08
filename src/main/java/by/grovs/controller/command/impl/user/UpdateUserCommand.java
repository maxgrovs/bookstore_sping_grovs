package by.grovs.controller.command.impl.user;

import by.grovs.controller.command.SpringCommand;
import by.grovs.entity.User;
import by.grovs.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;


@Component("update_user")
public class UpdateUserCommand implements SpringCommand {

    private final UserService service;

    public UpdateUserCommand(UserService service) {
        this.service = service;
    }


    @Override
    public String execute(HttpServletRequest request) {


        Long id = Long.parseLong(request.getParameter("id"));
        User user = service.findById(id);
        user.setFirstName(request.getParameter("name"));

        User updated = service.update(user);
        request.setAttribute("user", updated);
        request.setAttribute("message", "User has been updated!");

        return "WEB-INF/jsp/one-user.jsp";


    }
}