package by.grovs.dao;

import by.grovs.entity.Book;

import java.util.List;

public interface BookDao {

    //CRUD
    //create
    Book addBook(Book book);

    //read
    List<Book> getBooks();

    Book getById(Long id);

    //update
    Book update(Book book);

    //delete
    boolean delete(Long id);
}
