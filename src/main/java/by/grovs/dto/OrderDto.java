package by.grovs.dto;

import by.grovs.entity.Order;
import by.grovs.entity.OrderItem;
import by.grovs.entity.User;

import java.math.BigDecimal;
import java.util.List;


public class OrderDto {

    private Long id;
    private BigDecimal totalCost;
    private List<OrderItem> items;

    private String userFullName;
    private String status;


    public static OrderDto toDto(Order order) {
        return new OrderDto()
                .setUserFullName(order.getUser().getFirstName() + " " + order.getUser().getLastName())
                .setStatus(order.getStatus().name());
    }



    private OrderDto setStatus(String status) {
        this.status = status;
        return this;
    }

    public OrderDto setUserFullName(String userFullName) {
        this.userFullName = userFullName;
        return this;
    }


}
