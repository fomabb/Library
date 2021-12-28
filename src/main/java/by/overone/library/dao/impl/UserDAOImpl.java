package by.overone.library.dao.impl;

import by.overone.library.dao.UserDAO;
import by.overone.library.dao.mapper.UserRowMapper;
import by.overone.library.model.User;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserDAOImpl implements UserDAO {


    private final JdbcTemplate jdbcTemplate;

    private final static String GET_ALL_USER_SQL = "SELECT * FROM users";
    private final static String GET_USER_BY_STATUS_SQL = "SELECT * FROM users WHERE user_status = ?";
    private final static String GET_USER_BY_ID_SQL = "SELECT * FROM users WHERE user_id = ?";
    private final static String GET_USER_BY_LOGIN_SQL = "SELECT * FROM users WHERE user_login = ?";
    private final static String GET_USER_BY_FULL_NAME = "SELECT * FROM users JOIN user_details ON user_id = users_user_id " +
            "WHERE user_details_name = ? AND user_details_surname = ?";
    private final static String REGISTRATION_USER_SQL = "INSERT INTO users VALUE(0, ?, ?, ?, ?, ?)";
    private final static String GET_USER_DETAILS_BY_ID = "SELECT * FROM user_details WHERE users_user_id = ?";
    private final static String ADD_USER_DETAILS_ID_SQL = "INSERT INTO user_details(users_user_id) VALUE(?)";
    private final static String GET_INFO_SQL = "SELECT * FROM users JOIN user_details ON user_id = users_user_id WHERE user_id = ?";
    private final static String UPDATE_USER_STATUS_SQL = "UPDATE user SET status =(?) WHERE id=(?)";
    private final static String ADD_USER_DETAILS_SQL = "UPDATE user_details SET user_details_name=?, " +
            "user_detail_surname=?, user_detail_address=?, user_detail_phone=? WHERE users_user_id=?";
    private final static String DELETE_USER_SQL = "UPDATE users SET user_status=? WHERE user_id=?";
    private final static String GET_ALL_BOOKS_SQL = "SELECT * FROM books WHERE ";

    @Override
    public List<User> getAllUser() {
        List<User> users = jdbcTemplate.query(GET_ALL_USER_SQL, new UserRowMapper());
        return users;
    }

    @Override
    public User getUserById(long id) {
        return jdbcTemplate.query(GET_USER_BY_ID_SQL, new Object[]{id}, new UserRowMapper()).stream().findAny().orElse(null);
    }

    @Override
    public User getUserByLogin(String login) {
        return jdbcTemplate.query(GET_USER_BY_LOGIN_SQL, new Object[]{login}, new UserRowMapper()).stream().findAny().orElse(null);
    }

    @Override
    public User getUserByFullName(String name, String surname) {
        return jdbcTemplate.query(GET_USER_BY_FULL_NAME, new Object[]{name, surname}, new UserRowMapper()).stream().findAny().orElse(null);
    }

    @Override
    public List<User> getUserByStatus(String status) {
        List<User> users = jdbcTemplate.query(GET_USER_BY_STATUS_SQL, new Object[]{status}, new UserRowMapper());
        return users;
    }
}
