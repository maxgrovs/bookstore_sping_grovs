package by.grovs.service.impl;
import by.grovs.service.UserService;
import by.grovs.entity.User;
import by.grovs.dao.UserDao;
import by.grovs.dao.impl.UserDaoImpl;

import java.util.List;


public class UserServiceImpl implements UserService {

    private static final UserServiceImpl INSTANCE = new UserServiceImpl();

    public static UserServiceImpl getInstance() {
        return INSTANCE;
    }

    private final UserDao dao = UserDaoImpl.getInstance();

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
