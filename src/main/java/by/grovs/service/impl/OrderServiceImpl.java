package by.grovs.service.impl;

import by.grovs.dao.OrderDao;
import by.grovs.entity.Order;
import by.grovs.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderDao orderDao;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public Order findById(Long id) {
        Order order = orderDao.findById(id);
        return order;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Order update(Order entity) {
        return null;
    }

    @Override
    public Order create(Order entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
