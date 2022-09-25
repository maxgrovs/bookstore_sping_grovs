package by.grovs.controller.command.impl;

import by.grovs.controller.command.SpringCommand;
import by.grovs.entity.Book;
import by.grovs.entity.Order;
import by.grovs.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component("order")
public class OrderCommand implements SpringCommand {

    private final OrderService orderService;

    @Override
    public String execute(HttpServletRequest request) {


        Long id = Long.parseLong(request.getParameter("id"));
        Order order = orderService.findById(id);
        request.setAttribute("order", order);

        return "WEB-INF/jsp/one-order.jsp";


    }
}