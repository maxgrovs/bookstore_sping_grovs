package by.grovs.controller.command.impl.orderItem;

import by.grovs.controller.command.SpringCommand;
import by.grovs.entity.OrderItem;
import by.grovs.service.OrderItemService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("order_items")
public class OrderItemsCommand implements SpringCommand {

    private final OrderItemService orderItemService;

    public OrderItemsCommand(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }


    @Override
    public String execute(HttpServletRequest request)  {

        List<OrderItem> items = orderItemService.findAll();

        request.setAttribute("items", items);

        return "WEB-INF/jsp/order-items.jsp";

    }
}