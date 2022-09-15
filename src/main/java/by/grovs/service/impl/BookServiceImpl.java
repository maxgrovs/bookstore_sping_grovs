package by.grovs.service.impl;

import by.grovs.dao.BookDao;
import by.grovs.entity.Book;
import by.grovs.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookDao dao;

    @Autowired
    public BookServiceImpl(@Qualifier("bookDaoImpl") BookDao dao) {
        this.dao = dao;
    }


    public BigDecimal calcTotalCostByAuthor(String author) {

        return getAll().stream()
                .filter(o -> o.getAuthor().equals(author))
                .map(o -> o.getCost())
                .reduce((a, b) -> a.add(b))
                .get();
    }

    @Override
    public Book addBook(Book book) {
        return dao.addBook(book);
    }

    @Override
    public List<Book> getAll() {
        return dao.getBooks();
    }

    @Override
    public Book getById(Long id) {
        return dao.getById(id);
    }


    @Override
    public Book editBook(Book book) {
        return dao.update(book);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }


}
