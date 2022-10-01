package by.grovs.controller.command.impl.orderItem;

import by.grovs.controller.command.SpringCommand;
import by.grovs.entity.OrderItem;
import by.grovs.service.OrderItemService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component("order_items_by_order")
public class OrderItemByOrderCommand implements SpringCommand {

    private final OrderItemService orderItemService;

    @Override
    public String execute(HttpServletRequest request) {


        Long id = Long.parseLong(request.getParameter("id"));
        List<OrderItem> items = orderItemService.findByOrderId(id);
        request.setAttribute("items", items);

        return "WEB-INF/jsp/order-items-by-order.jsp";


    }
}