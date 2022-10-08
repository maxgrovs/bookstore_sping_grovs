package by.grovs.controller.command.impl.orderItem;

import by.grovs.controller.command.SpringCommand;
import by.grovs.entity.OrderItem;
import by.grovs.service.OrderItemService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component("order_item")
public class OrderItemCommand implements SpringCommand {

    private final OrderItemService orderItemService;

    @Override
    public String execute(HttpServletRequest request) {


        Long id = Long.parseLong(request.getParameter("id"));
        OrderItem orderItem = orderItemService.findById(id);
        request.setAttribute("item", orderItem);

        return "WEB-INF/jsp/one-order-item.jsp";


    }
}