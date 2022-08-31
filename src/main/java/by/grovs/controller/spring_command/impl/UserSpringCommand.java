package by.grovs.controller.spring_command.impl;

import by.grovs.controller.spring_command.SpringCommand;
import by.grovs.entity.Book;
import by.grovs.entity.User;
import by.grovs.service.BookService;
import by.grovs.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("user")
public class UserSpringCommand implements SpringCommand {

    private final UserService userService;

    @Autowired
    public UserSpringCommand(UserService userService) {
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