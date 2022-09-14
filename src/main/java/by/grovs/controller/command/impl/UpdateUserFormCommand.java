package by.grovs.controller.command.impl;

import by.grovs.controller.command.SpringCommand;
import by.grovs.entity.User;
import by.grovs.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;


@Component("update_user_form")
public class UpdateUserFormCommand implements SpringCommand {

    private final UserService userService;

    public UpdateUserFormCommand(UserService userService) {
        this.userService = userService;
    }


    @Override
    public String execute(HttpServletRequest request) {

        Long id = Long.parseLong(request.getParameter("id"));
        User user = userService.getById(id);

        request.setAttribute("user", user);

        return "WEB-INF/jsp/update-user-form.jsp";

    }
}