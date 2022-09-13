package by.grovs.dao.impl.user;

import by.grovs.dao.UserDao;
import by.grovs.entity.User;
import by.grovs.service.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class UserDaoSpringImpl implements UserDao {

    private static final Logger log = LogManager.getLogger(UserDaoSpringImpl.class);

    private final JdbcTemplate jdbcTemplate;

    public static final String FIND_ALL = "SELECT * FROM users";
    public static final String FIND_ONE = "SELECT id, first_name, last_name, password FROM users WHERE id = ?";

    private final Util util = Util.getInstance();

    public UserDaoSpringImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    //read all
    @Override
    public List<User> getUsers() {

        return jdbcTemplate.query(FIND_ALL, this::getUser);
    }

    //Read one
    public User getById(Long id) {

        return jdbcTemplate.queryForObject(FIND_ONE, this::getUser, id);
    }

    private User getUser(ResultSet resultSet, int rawNum) {
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
            log.error(throwables);
        }
        return user;
    }

}
