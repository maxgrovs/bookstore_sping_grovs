package by.grovs.service;
import by.grovs.entity.Book;

import java.util.List;

public interface BookService {

    //crud

    //create
    Book addBook(Book book);

    //read
    List<Book> getAll();

    Book getById(Long id);

    //update
    Book editBook(Book book);

    //delete
    void delete(Long id);



}
