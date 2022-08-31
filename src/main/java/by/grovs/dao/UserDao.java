package by.grovs.dao;
import by.grovs.entity.User;

import java.util.List;

public interface UserDao {

    //read
    List<User> getUsers();

    User getById(Long id);

}
