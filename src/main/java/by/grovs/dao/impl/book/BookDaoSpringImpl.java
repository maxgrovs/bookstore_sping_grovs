package by.grovs.dao.impl.book;

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

import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class BookDaoSpringImpl implements BookDao {

    private static final Logger log = LogManager.getLogger(BookDaoSpringImpl.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private BookDaoSpringImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public static final String ADD_BOOK = "INSERT INTO books (name, author, isbn, date )" +
            "VALUES (?, ?, ?, ?)";
    public static final String FIND_ALL = "SELECT * FROM books";
    public static final String FIND_ONE = "SELECT id, name, author, isbn, date, cost FROM books WHERE id = ?";
    public static final String FIND_ONE_BY_ISBN = "SELECT * FROM books WHERE isbn = ?";
    public static final String FIND_ALL_BY_AUTHOR = "SELECT * FROM books WHERE author = ?";
    public static final String UPDATE_BOOKS = "UPDATE books SET name = ? WHERE id = ?";
    public static final String INSERT_BOOKS = "INSERT INTO books (name, author, isbn, date ) VALUES ?, ?, ?, ?";


    private final Util util = Util.getInstance();

    public Book addBook(Book book) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        String isbn = util.getIsbn();
        LocalDate date = util.getRandomDateOfPublication();

        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(ADD_BOOK);
            ps.setString(1, book.getName());
            ps.setString(1, book.getAuthor());
            ps.setString(3, isbn);
            ps.setDate(4, Date.valueOf(date));
            return ps;
        }, keyHolder);

        Long id = Optional.ofNullable(keyHolder.getKey())
                .orElseThrow(() -> new RuntimeException("Can't create book"))
                .longValue();

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

        return false;

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
      //  book.setCost(rs.getBigDecimal("cost"));

        return book;
    }

}
