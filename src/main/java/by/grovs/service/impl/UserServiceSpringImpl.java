package by.grovs.service.impl;

import by.grovs.dao.UserDao;
import by.grovs.entity.User;
import by.grovs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceSpringImpl implements UserService {

    private final UserDao dao;

    @Autowired
    public UserServiceSpringImpl(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return dao.getUsers();
    }

    @Override
    public User getById(Long id) {
        return dao.getById(id);
    }

    @Override
    public User editUser(User user) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
