package by.overone.library.dao.impl;

import by.overone.library.dao.UserDAO;
import by.overone.library.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUser() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        criteriaQuery.from(User.class);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

//    @Override
//    public User getUserById(long id) {
//        return jdbcTemplate.query(GET_USER_BY_ID_SQL, new Object[]{id}, new UserRowMapper()).stream()
//                .findAny()
//                .orElse(null);
//    }
//
//    @Override
//    public User getUserByLogin(String login) {
//        return jdbcTemplate.query(GET_USER_BY_LOGIN_SQL, new Object[]{login}, new UserRowMapper()).stream()
//                .findAny()
//                .orElse(null);
//    }
//
//    @Override
//    public User getUserByEmail(String email) {
//        return jdbcTemplate.query(GET_USER_BY_EMAIL_SQL, new Object[]{email}, new UserRowMapper()).stream()
//                .findAny()
//                .orElse(null);
//    }
//
//    @Override
//    public List<User> getUserByStatus(String status) {
//        return jdbcTemplate.query(GET_USER_BY_STATUS_SQL, new Object[]{status}, new UserRowMapper());
//    }
//
//    @Override
//    public User getUserByFullName(String name, String surname) {
//        return jdbcTemplate.query(GET_USER_BY_FULL_NAME, new Object[]{name, surname}, new UserRowMapper()).stream()
//                .findAny()
//                .orElse(null);
//    }
//
//    @Override
//    public UserAllInfoDTO getUserAllInfo(long id) {
//        return jdbcTemplate.queryForObject(GET_INFO_SQL, new Object[]{id},
//                new BeanPropertyRowMapper<>(UserAllInfoDTO.class));
//    }
//
//    @Override
//    public void addUser(User user) {
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//        SqlParameterSource parameterSource = new MapSqlParameterSource()
//                .addValue("user_login", user.getUser_login())
//                .addValue("user_password", user.getUser_password())
//                .addValue("user_email", user.getUser_email())
//                .addValue("user_role", user.getUser_role().toString())
//                .addValue("user_status", user.getUser_status().toString());
//        namedParameterJdbcTemplate.update(ADD_USER_SQL, parameterSource, keyHolder, new String[]{"user_id"});
//        user.setUser_id(keyHolder.getKey().longValue());
//        jdbcTemplate.update(ADD_USER_DETAILS_ID_SQL, user.getUser_id());
//    }
//
//    @Override
//    public void deleteUser(long user_id) {
//        jdbcTemplate.update(DELETE_USER_SQL, user_id);
//    }
//
//    @Override
//    public void addUserDetails(UserDetailsDTO userDetailsDTO) {
//        jdbcTemplate.update(ADD_USER_DETAILS_SQL, userDetailsDTO.getUser_details_name(),
//                userDetailsDTO.getUser_details_surname(), userDetailsDTO.getUser_details_address(),
//                userDetailsDTO.getUser_details_phonenumber(), userDetailsDTO.getUsers_user_id());
//    }
//
//    @Override
//    public UserDetails getUserDetailsById(long id) {
//        return jdbcTemplate.query(GET_USER_DETAILS_BY_ID, new Object[]{id}, new UserDetailsRowMapper()).stream()
//                .findAny()
//                .orElse(null);
//    }
//
//    @Override
//    public void userUpdate(long id, UserUpdateDTO userUpdateDTO) {
//        jdbcTemplate.update(UPDATE_USER_LOGIN_SQL, userUpdateDTO.getLogin(), id);
//    }
}
