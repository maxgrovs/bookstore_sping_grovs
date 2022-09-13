package by.grovs.dao.impl.user;

import by.grovs.service.Util;
import by.grovs.entity.User;
import by.grovs.dao.UserDao;
import by.grovs.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static final UserDaoImpl INSTANCE = new UserDaoImpl();

    public static UserDaoImpl getInstance() {
        return INSTANCE;
    }

    Connection connection;

    private UserDaoImpl() {
        try {
            connection = ConnectionManager.get();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static final String FIND_ALL = "SELECT * FROM users";
    public static final String FIND_ONE = "SELECT id, first_name, last_name, password FROM users WHERE id = ?";

    private final Util util = Util.getInstance();


    //read all
    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();

        try {
            ResultSet resultSet = getResultSet(FIND_ALL);

            while (resultSet.next()) {

                users.add(getUser(resultSet));

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;//FIXME
    }

    //Read one
    public User getById(Long id) {
        User user = new User();

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ONE);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                user = getUser(resultSet);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user;
    }


    private ResultSet getResultSet(String sql) {

        ResultSet resultSet = null;

        try {
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            resultSet = statement.executeQuery(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    private User getUser(ResultSet resultSet) {
        User user = new User();
        try {
            user.setId(resultSet.getLong("id"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setPassword(resultSet.getString("password"));
//            Role[] values = Role.values();
//            Role role = values[((int) resultSet.getLong("role_id")) + 1];
//            user.setRole(role);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

}
