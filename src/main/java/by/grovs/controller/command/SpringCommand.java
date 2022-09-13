package by.grovs.controller.command;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public interface SpringCommand {

    String execute(HttpServletRequest request)
            throws ServletException, IOException;

}
