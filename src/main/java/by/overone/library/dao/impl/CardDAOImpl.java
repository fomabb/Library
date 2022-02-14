package by.overone.library.dao.impl;

import by.overone.library.dao.Card;
import by.overone.library.dao.mapper.UserRowMapper;
import by.overone.library.dto.UserGetByBooks;
import by.overone.library.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class CardDAOImpl implements Card {

    private final String GET_USER_BY_BOOKS = "SELECT * FROM card WHERE card = (SELECT card FROM card WHERE word = 'myword')";

    JdbcTemplate jdbcTemplate;

    @Override
    public User getByBooks(long id, UserGetByBooks userGetByBooks) {
        return jdbcTemplate.query(GET_USER_BY_BOOKS, new Object[]{id}, new UserRowMapper())
                .stream()
                .findAny()
                .orElse(null);
    }
}
