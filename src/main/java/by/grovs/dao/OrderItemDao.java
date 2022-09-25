package by.grovs.dao;
import by.grovs.entity.OrderItem;

import java.util.List;

public interface OrderItemDao extends CrudDao <OrderItem, Long> {

    List<OrderItem> findByOrderId(Long id);

}
