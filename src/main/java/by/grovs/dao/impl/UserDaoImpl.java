package by.grovs.dao.impl;

import by.grovs.dao.UserDao;
import by.grovs.entity.User;
import by.grovs.service.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    private static final Logger log = LogManager.getLogger(UserDaoImpl.class);
    public static final String DELETE_USER = "UPDATE users SET deleted = true WHERE id = ?";

    private final JdbcTemplate jdbcTemplate;

    public static final String INSERT_USER = "INSERT INTO users (first_name, last_name, role, password) " +
            "VALUES (?, ?, ?, ?)";
    public static final String FIND_ALL = "SELECT * FROM users WHERE deleted = false";
    public static final String FIND_ONE = "SELECT id, first_name, last_name, password FROM users WHERE id = ?";
    public static final String UPDATE_USER = "UPDATE users SET first_name = ? WHERE id = ?";

    private final Util util = Util.getInstance();

    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public User create(User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();


        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
           // ps.setString(3, user.getRole().name());
            ps.setString(3, "Admin");
           // ps.setString(4, user.getPassword());
            ps.setString(4, "123");
            return ps;
        }, keyHolder);

        Long id = (Long) Optional.ofNullable(keyHolder.getKeys().get("id"))
                .orElseThrow(() -> new RuntimeException("Can't create user"));

        System.out.println();

        return findById(id);
    }


    @Override
    public List<User> findAll() {

        return jdbcTemplate.query(FIND_ALL, this::getUser);
    }


    public User findById(Long id) {

        return jdbcTemplate.queryForObject(FIND_ONE, this::getUser, id);
    }

    public User update(User user) {

        jdbcTemplate.update(UPDATE_USER, ps -> {
            ps.setString(1, user.getFirstName());
            ps.setLong(2, user.getId());
        });
        return findById(user.getId());

    }

    @Override
    public boolean delete(Long id) {

        jdbcTemplate.update(DELETE_USER, ps -> {
            ps.setLong(1, id);
        });

        return true;
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
