package by.grovs.controller.command.impl.order;

import by.grovs.controller.command.SpringCommand;
import by.grovs.entity.Order;
import by.grovs.entity.OrderItem;
import by.grovs.service.OrderItemService;
import by.grovs.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component("orders")
public class OrdersCommand implements SpringCommand {

    private final OrderService orderService;
    private final OrderItemService orderItemService;

    @Override
    public String execute(HttpServletRequest request)  {

        List<Order> orders = orderService.findAll();
        request.setAttribute("orders", orders);

        return "WEB-INF/jsp/orders.jsp";

    }
}