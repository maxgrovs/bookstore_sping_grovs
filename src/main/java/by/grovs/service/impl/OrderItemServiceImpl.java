package by.grovs.service.impl;

import by.grovs.dao.OrderItemDao;
import by.grovs.entity.Order;
import by.grovs.entity.OrderItem;
import by.grovs.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemDao orderItemDao;

    @Autowired
    public OrderItemServiceImpl(OrderItemDao orderItemDao) {
        this.orderItemDao = orderItemDao;
    }

    @Override
    public List<OrderItem> findByOrderId(Long id) {
        return orderItemDao.findByOrderId(id);
    }

    @Override
    public OrderItem findById(Long id) {
        OrderItem orderItem = orderItemDao.findById(id);
        return orderItem;
    }

    @Override
    public List<OrderItem> findAll() {

        return orderItemDao.findAll();
    }

    @Override
    public OrderItem update(OrderItem entity) {
        return null;
    }

    @Override
    public OrderItem create(OrderItem entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }


}
