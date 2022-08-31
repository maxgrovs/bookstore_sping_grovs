package by.grovs.service;
import by.grovs.entity.User;

import java.util.List;

public interface UserService {

    //crud

    //create
    User addUser(User user);

    //read
    List<User> getAll();

    User getById(Long id);

    //update
    User editUser(User user);

    //delete
    void delete(Long id);



}
