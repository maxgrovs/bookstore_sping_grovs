package by.grovs.dao.impl;

import by.grovs.dao.OrderDao;
import by.grovs.dao.OrderItemDao;
import by.grovs.dao.UserDao;
import by.grovs.entity.Book;
import by.grovs.entity.Order;
import by.grovs.entity.OrderItem;
import by.grovs.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class OrderDaoImpl implements OrderDao {

    private final UserDao userDao;
    private final OrderItemDao orderItemDao;
    private final JdbcTemplate jdbcTemplate;

    private static final String GET_BY_ID =
            "SELECT id, status, total_cost, user_id " +
                    "FROM orders " +
                    "WHERE id = ?";


    @Override
    public Order findById(Long id) {
        return jdbcTemplate.queryForObject(GET_BY_ID, this::mapRow, id);
    }

    private Order mapRow(ResultSet resultSet, int i) throws SQLException {

        Order order = new Order();
        order.setId(resultSet.getLong("id"));

        order.setStatus(Order.Status.valueOf(resultSet.getString("status")));
        order.setTotalCost(resultSet.getBigDecimal("total_cost"));
        Long userId = resultSet.getLong("user_id");
        User user = userDao.findById(userId);
        order.setUser(user);
     //   List<OrderItem> items = orderItemDao.findByOrderId(userId);
       // order.setItems(items);
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
    public boolean delete(Long id) {
        return false;
    }


    public Order getOrder(ResultSet rs, int rowNum) throws SQLException {

        Order order = new Order();
        order.setId(rs.getLong("id"));
        order.setStatus(Order.Status.valueOf(rs.getString("status")));
//        order.setUser(rs.getString("author"));
//        book.setIsbn(rs.getString("isbn"));
//        book.setDate((rs.getDate("date")).toLocalDate());
//        book.setCost(rs.getBigDecimal("cost"));

        return order;
    }

}
