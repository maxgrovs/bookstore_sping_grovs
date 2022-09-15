package by.grovs.controller.command.impl;


import by.grovs.controller.command.SpringCommand;
import by.grovs.entity.User;
import by.grovs.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component("users")
public class UsersCommand implements SpringCommand {

    private final UserService userService;

    @Autowired
    public UsersCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {

        List<User> users = userService.findAll();

        request.setAttribute("users", users);

        return "WEB-INF/jsp/users.jsp";

    }
}