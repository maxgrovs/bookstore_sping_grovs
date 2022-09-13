package by.grovs.controller.command.impl;

import by.grovs.controller.command.SpringCommand;
import by.grovs.entity.User;
import by.grovs.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("user")
public class UserCommand implements SpringCommand {

    private final UserService userService;

    @Autowired
    public UserCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {


        Long id = Long.parseLong(request.getParameter("id"));
        User user = userService.getById(id);
        request.setAttribute("user", user);

        return "WEB-INF/jsp/one-user.jsp";


    }
}