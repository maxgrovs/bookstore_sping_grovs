package by.grovs.dao;
import by.grovs.entity.Book;
import by.grovs.entity.User;

import java.util.List;

public interface UserDao {

    //create
    User addUser(User user);

    //read
    List<User> getUsers();

    User getById(Long id);

    //update
    User update(User user);

    //delete
    boolean delete(Long id);


}
