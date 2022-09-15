package by.grovs.service.impl;

import by.grovs.dao.UserDao;
import by.grovs.entity.User;
import by.grovs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao dao;

    @Autowired
    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    public User create(User user) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public User findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public User update(User user) {
        return dao.update(user);
    }

    @Override
    public void delete(Long id) {

    }
}
