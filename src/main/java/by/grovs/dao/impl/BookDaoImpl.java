package by.grovs.dao.impl;

import by.grovs.dao.BookDao;
import by.grovs.entity.Book;
import by.grovs.service.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class BookDaoImpl implements BookDao {

    private static final Logger log = LogManager.getLogger(BookDaoImpl.class);


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private BookDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public static final String ADD_BOOK = "INSERT INTO books (name, author, isbn, date, cost )" +
            "VALUES (?, ?, ?, ?, ?)";
    public static final String FIND_ALL = "SELECT * FROM books WHERE deleted = false";
    public static final String FIND_ONE = "SELECT id, name, author, isbn, date, cost FROM books WHERE id = ?";
    public static final String FIND_ONE_BY_ISBN = "SELECT * FROM books WHERE isbn = ?";
    public static final String FIND_ALL_BY_AUTHOR = "SELECT * FROM books WHERE author = ?";
    public static final String UPDATE_BOOKS = "UPDATE books SET name = ? WHERE id = ?";
    public static final String DELETE_BOOK = "UPDATE books SET deleted = true WHERE id = ?";

    private final Util util = Util.getInstance();

    public Book addBook(Book book) {

       KeyHolder keyHolder = new GeneratedKeyHolder();

        String isbn = util.getIsbn();
        LocalDate date = util.getRandomDateOfPublication();
        BigDecimal cost = util.getRandomCost(BigDecimal.valueOf(1), BigDecimal.valueOf(1000));

        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(ADD_BOOK, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, book.getName());
            ps.setString(2, book.getAuthor());
            ps.setString(3, isbn);
            ps.setDate(4, Date.valueOf(date));
            ps.setBigDecimal(5, cost);
            return ps;
        }, keyHolder);

        Long id = (Long) Optional.ofNullable(keyHolder.getKeys().get("id"))
                .orElseThrow(() -> new RuntimeException("Can't create book"));

        return getById(id);
    }


    public List<Book> getBooks() {

        return jdbcTemplate.query(FIND_ALL, this::getBook);
    }

    public List<Book> getBooksByAuthor(String author) {
        return null;
    }

    //Read one
    public Book getById(Long id) {

        return jdbcTemplate.queryForObject(FIND_ONE, this::getBook, id);
    }

    public Book update(Book book) {

        jdbcTemplate.update(UPDATE_BOOKS, ps -> {
            ps.setString(1, book.getName());
            ps.setLong(2, book.getId());
        });
        return getById(book.getId());

    }

    public boolean delete(Long id) {

        jdbcTemplate.update(DELETE_BOOK, ps -> {
           ps.setLong(1, id);
        });

        return true;

    }

    public Book getByIsbn(String isbn) {
        return null;
    }


    public long countAllBooks() {
        return getBooks().size();
    }


    public Book getBook(ResultSet rs, int rowNum) throws SQLException {

        Book book = new Book();
        book.setId(rs.getLong("id"));
        book.setName(rs.getString("name"));
        book.setAuthor(rs.getString("author"));
        book.setIsbn(rs.getString("isbn"));
        book.setDate((rs.getDate("date")).toLocalDate());
        book.setCost(rs.getBigDecimal("cost"));

        return book;
    }

}
