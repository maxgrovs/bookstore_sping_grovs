package by.grovs.dto;

import by.grovs.entity.Book;
import by.grovs.entity.Order;

import java.math.BigDecimal;


public class OrderItemDto {

    private Long id;
    private Book book;
    private Order order;
    private Integer quantity;
    private BigDecimal totalPrice;




    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", book=" + book +
                ", order=" + order.getId() +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
