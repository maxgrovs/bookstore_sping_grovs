package by.grovs.service;
import by.grovs.entity.OrderItem;

import java.util.List;

public interface OrderItemService extends AbstractService<OrderItem, Long>{

    public List<OrderItem> findByOrderId(Long id);

}
