package by.grovs.dao.impl;

import by.grovs.dao.BookDao;
import by.grovs.dao.OrderItemDao;
import by.grovs.entity.Book;
import by.grovs.entity.OrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderItemDaoImpl implements OrderItemDao {

    private final JdbcTemplate jdbcTemplate;
    private final BookDao bookDao;


    @Override
    public OrderItem findById(Long id) {
        return null;
    }

    @Override
    public List<OrderItem> findAll() {
        return null;
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
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<OrderItem> findByOrderId(Long id) {
        return jdbcTemplate.query("SELECT * FROM users WHERE id = ?", this::mapRow, id);
    }

    private OrderItem mapRow(ResultSet resultSet, int i) throws SQLException {
        OrderItem orderItem = new OrderItem();
        long book_id = resultSet.getLong("book_id");
        Book book = bookDao.getById(book_id);
        orderItem.setBook(book);
        return orderItem;
    }
}
