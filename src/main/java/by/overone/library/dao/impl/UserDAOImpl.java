package by.overone.library.dao.impl;

import by.overone.library.dao.UserDAO;
import by.overone.library.dao.mapper.UserAllInfoMapper;
import by.overone.library.dao.mapper.UserDetailsRowMapper;
import by.overone.library.dao.mapper.UserRowMapper;
import by.overone.library.dto.UserDetailsDTO;
import by.overone.library.dto.UserFullInfoDTO;
import by.overone.library.dto.UserUpdateDTO;
import by.overone.library.dto.UserUpdateDetailsDTO;
import by.overone.library.model.User;
import by.overone.library.model.UserDetails;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@AllArgsConstructor
public class UserDAOImpl implements UserDAO {

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final static String GET_ALL_USER_SQL = "SELECT * FROM users";
    private final static String GET_USER_BY_STATUS_SQL = "SELECT * FROM users WHERE user_status=?";
    private final static String GET_USER_BY_ID_SQL = "SELECT * FROM users WHERE user_id=?";
    private final static String GET_USER_BY_LOGIN_SQL = "SELECT * FROM users WHERE user_login=?";
    private final static String GET_USER_BY_EMAIL_SQL = "SELECT * FROM users WHERE user_email = ?";
    private final static String GET_USER_BY_FULL_NAME = "SELECT * FROM users JOIN user_details ON user_id= " +
            "users_user_id WHERE user_details_name = ? AND user_details_surname=?";
    private final static String ADD_USER_SQL = "INSERT INTO users(user_login, user_password, user_email, " +
            "user_role, user_status) VALUES(:user_login, :user_password, :user_email, :user_role, " +
            ":user_status)";
    private final static String GET_USER_DETAILS_BY_ID = "SELECT * FROM user_details WHERE users_user_id = ?";
    private final static String ADD_USER_DETAILS_ID_SQL = "INSERT INTO user_details(users_user_id) VALUE(?)";
    private final static String GET_INFO_SQL = "SELECT * FROM users JOIN user_details ON user_id = users_user_id " +
            "WHERE user_id = ?";
    private final static String UPDATE_USER_LOGIN_SQL = "UPDATE users SET user_login=?, user_password=?, user_email=? " +
            "WHERE user_id=?";
    private final static String UPDATE_USER_STATUS = "UPDATE users SET user_status='ACTIVE' WHERE user_id=?";
    private final static String ADD_USER_DETAILS_SQL = "UPDATE user_details SET user_details_name=?, " +
            "user_details_surname=?, user_details_address=?, user_details_phonenumber=? WHERE users_user_id=?";
    private final static String DELETE_USER_SQL = "UPDATE users SET user_status='INACTIVE' WHERE user_id=?";
    private final static String UPDATE_USER_DETAILS_SQL = "UPDATE user_details SET user_details_name=?, " +
            "user_details_surname=?, user_details_address=?, user_details_phonenumber=? WHERE users_user_id=?";

    @Override
    public List<User> getAllUser() {
        return jdbcTemplate.query(GET_ALL_USER_SQL, new UserRowMapper());
    }

    @Override
    public User getUserById(long id) {
        return jdbcTemplate.query(GET_USER_BY_ID_SQL, new Object[]{id}, new UserRowMapper()).stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public User getUserByLogin(String login) {
        return jdbcTemplate.query(GET_USER_BY_LOGIN_SQL, new Object[]{login}, new UserRowMapper()).stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public User getUserByEmail(String email) {
        return jdbcTemplate.query(GET_USER_BY_EMAIL_SQL, new Object[]{email}, new UserRowMapper()).stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public List<User> getUserByStatus(String status) {
        return jdbcTemplate.query(GET_USER_BY_STATUS_SQL, new Object[]{status}, new UserRowMapper());
    }

    @Override
    public User getUserByFullName(String name, String surname) {
        return jdbcTemplate.query(GET_USER_BY_FULL_NAME, new Object[]{name, surname}, new UserRowMapper()).stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public UserFullInfoDTO getUserFullInfo(long id) {
        return jdbcTemplate.query(GET_INFO_SQL, new Object[]{id}, new UserAllInfoMapper()).stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public void addUser(User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("user_login", user.getUser_login())
                .addValue("user_password", user.getUser_password())
                .addValue("user_email", user.getUser_email())
                .addValue("user_role", user.getUser_role().toString())
                .addValue("user_status", user.getUser_status().toString());
        namedParameterJdbcTemplate.update(ADD_USER_SQL, parameterSource, keyHolder, new String[]{"user_id"});
        user.setUser_id(keyHolder.getKey().longValue());
        jdbcTemplate.update(ADD_USER_DETAILS_ID_SQL, user.getUser_id());
    }

    @Override
    public void deleteUser(long user_id) {
        jdbcTemplate.update(DELETE_USER_SQL, user_id);
    }

    @Override
    public void addUserDetails(UserDetailsDTO userDetailsDTO) {
        jdbcTemplate.update(ADD_USER_DETAILS_SQL, userDetailsDTO.getUser_details_name(),
                userDetailsDTO.getUser_details_surname(), userDetailsDTO.getUser_details_address(),
                userDetailsDTO.getUser_details_phonenumber(), userDetailsDTO.getUsers_user_id());
    }

    @Override
    public UserDetails getUserDetailsById(long id) {
        return jdbcTemplate.query(GET_USER_DETAILS_BY_ID, new Object[]{id}, new UserDetailsRowMapper()).stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public void userUpdate(long id, UserUpdateDTO userUpdateDTO) {
        jdbcTemplate.update(UPDATE_USER_LOGIN_SQL, userUpdateDTO.getLogin(), userUpdateDTO.getPassword(),
                userUpdateDTO.getEmail(), id);
    }

    @Override
    public void userUpdateDetails(long id, UserUpdateDetailsDTO userUpdateDetailsDTO) {
        jdbcTemplate.update(UPDATE_USER_DETAILS_SQL, userUpdateDetailsDTO.getUser_details_name(),
                userUpdateDetailsDTO.getUser_details_surname(), userUpdateDetailsDTO.getUser_details_address(),
                userUpdateDetailsDTO.getUser_details_phonenumber(), id);
    }

    @Override
    public void userUpdateStatus(long id) {
        jdbcTemplate.update(UPDATE_USER_STATUS, id);
    }
}
