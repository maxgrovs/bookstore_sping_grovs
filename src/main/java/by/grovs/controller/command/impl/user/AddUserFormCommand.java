package by.grovs.controller.command.impl.user;

import by.grovs.controller.command.SpringCommand;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;


@Component("add_user_form")
public class AddUserFormCommand implements SpringCommand {

    @Override
    public String execute(HttpServletRequest request) {

        return "WEB-INF/jsp/add-user-form.jsp";

    }
}