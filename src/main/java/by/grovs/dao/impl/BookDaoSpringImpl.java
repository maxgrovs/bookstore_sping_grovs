package by.grovs.dao.impl;

import by.grovs.dao.BookDao;
import by.grovs.entity.Book;
import by.grovs.service.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;

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

    private final Util util = Util.getInstance();


    //CRUD
    //_________________________________________________

    //create
    public Book addBook(Book book) {
        return null;

//        try {
//
//            PreparedStatement preparedStatement = connection.prepareStatement(
//                    ADD_BOOK, PreparedStatement.RETURN_GENERATED_KEYS);
//
//            String isbn = util.getIsbn();
//            LocalDate date = util.getRandomDateOfPublication();
//
//            preparedStatement.setString(1, book.getName());
//            preparedStatement.setString(2, book.getAuthor());
//            preparedStatement.setString(3, isbn);
//            preparedStatement.setDate(4, Date.valueOf(date));
//
//            preparedStatement.executeUpdate();
//            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
//
//            if (generatedKeys.next()) {
//
//                getBook(generatedKeys);
//
//            }
//
//        } catch (SQLException throwables) {
//           log.error(throwables);
//        }
//
//        return book;
    }

    //read all
    public List<Book> getBooks() {

        return jdbcTemplate.query(FIND_ALL, this::getBook);
    }

    public List<Book> getBooksByAuthor(String author) {
        return null;
//
//        List<Book> books = new ArrayList<>();
//
//        try {
//
//            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_BY_AUTHOR);
//            preparedStatement.setString(1, author);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//
//                Book book = getBook(resultSet);
//
//                books.add(book);
//
//            }
//
//        } catch (SQLException throwables) {
//            log.error(throwables);
//        }
//        return books;
    }

    //Read one
    public Book getById(Long id) {

        return jdbcTemplate.queryForObject(FIND_ONE, this::getBook, id);
    }

    public Book update(Book book) {
        return null;
//        try {
//            ResultSet resultSet = getResultSet(FIND_ALL);
//
//            while (resultSet.next()) {
//                long id = resultSet.getLong(1);
//                if (id == book.getId()) {
//                    resultSet.updateString("name", book.getName());
//                    resultSet.updateString("author", book.getAuthor());
//
//                    resultSet.updateRow();
//
//                    book.setIsbn(resultSet.getString("isbn"));
//                    book.setDate((resultSet.getDate("date")).toLocalDate());
//
//                }
//            }
//
//        } catch (SQLException e) {
//            log.error(e);
//        }
//
//        return book;
    }

    //delete
    public boolean delete(Long id) {

        return false;

//        boolean result = false;
//        try {
//            ResultSet resultSet = getResultSet(FIND_ALL);
//
//            while (resultSet.next()) {
//                long currentId = resultSet.getLong(1);
//                if (currentId == id) {
//                    resultSet.deleteRow();
//                    result = true;
//                }
//            }
//
//        } catch (SQLException e) {
//            log.error(e);
//        }
//
//        return result;
    }

    public Book getByIsbn(String isbn) {
        return null;
//        Book book = new Book();
//        try {
//
//            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ONE_BY_ISBN);
//            preparedStatement.setString(1, isbn);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            if (resultSet.next()) {
//
//                book = getBook(resultSet);
//
//            }
//
//        } catch (SQLException throwables) {
//            log.error(throwables);
//        }
//
//        return book;
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
