package by.grovs.controller.spring_command.impl;


import by.grovs.controller.spring_command.SpringCommand;
import by.grovs.entity.User;
import by.grovs.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component("users")
public class UsersSpringCommand implements SpringCommand {

    private final UserService userService;

    @Autowired
    public UsersSpringCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {

        List<User> users = userService.getAll();

        request.setAttribute("users", users);

        return "WEB-INF/jsp/users.jsp";

    }
}