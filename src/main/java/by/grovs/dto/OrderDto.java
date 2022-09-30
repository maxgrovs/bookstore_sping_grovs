package by.grovs.dto;

import by.grovs.entity.Order;
import by.grovs.entity.OrderItem;
import by.grovs.entity.User;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class OrderDto {


    private BigDecimal totalCost;
    private List<OrderItem> items;

    private Long id;
    private String userFullName;
    private String status;


    public static OrderDto toDto(Order order) {
        return new OrderDto()
                .setId(order.getId())
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

    public OrderDto setId(Long id) {
        this.id = id;
        return this;
    }
}
