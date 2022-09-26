package by.grovs.controller.command.impl.order;

import by.grovs.controller.command.SpringCommand;
import by.grovs.entity.Order;
import by.grovs.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("orders")
public class OrdersCommand implements SpringCommand {

    private final OrderService orderService;

    public OrdersCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String execute(HttpServletRequest request)  {

        List<Order> orders = orderService.findAll();

        request.setAttribute("orders", orders);

        return "WEB-INF/jsp/orders.jsp";

    }
}