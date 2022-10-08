package by.grovs.dao.impl;

import by.grovs.dao.BookDao;
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
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class OrderDaoImpl implements OrderDao {


    private final UserDao userDao;
    private final BookDao bookDao;
    private final OrderItemDao orderItemDao;
    private final JdbcTemplate jdbcTemplate;

    public static final String FIND_ALL = "SELECT * FROM orders WHERE deleted = false";
    private static final String GET_BY_ID =
            "SELECT id, status, total_cost, user_id " +
                    "FROM orders " +
                    "WHERE id = ?";



    @Override
    public Order findById(Long id) {

        return jdbcTemplate.queryForObject(GET_BY_ID, this::mapRow, id);
    }


    @Override
    public List<Order> findAll() {

            return jdbcTemplate.query(FIND_ALL, this::mapRow);
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

    private Order mapRow(ResultSet rs, int i) throws SQLException {
        Order order = new Order();
        order.setId(rs.getLong("id"));
        order.setStatus(Order.Status.valueOf(rs.getString("status")));
        order.setUser(userDao.findById(rs.getLong("user_id")));
        order.setTotalCost(rs.getBigDecimal("total_cost"));
        order.setItems(orderItemDao.findByOrderId(rs.getLong("id")));
        return order;
    }


}
