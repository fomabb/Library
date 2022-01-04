package by.overone.library.dao.impl;

import by.overone.library.dao.BookDAO;
import by.overone.library.model.Book;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class BookDAOImpl implements BookDAO {

    private final JdbcTemplate jdbcTemplate;

    private final static String GET_ALL_BOOKS_SQL = "SELECT * FROM bibliophile.books";
    private final static String GET_BOOKS_BY_ID_SQL = "SELECT * FROM books WHERE book_id = ?";

    @Override
    public List<Book> getAllBook() {
        List<Book> books = jdbcTemplate.query(GET_ALL_BOOKS_SQL, new BeanPropertyRowMapper<>(Book.class));
        return books;
    }
}
