package by.overone.library.dao.impl;

import by.overone.library.dao.BookDAO;
import by.overone.library.dao.mapper.BookRowMapper;
import by.overone.library.dto.BookDataDTO;
import by.overone.library.dto.BookUpdateDTO;
import by.overone.library.model.Book;
import by.overone.library.model.Status;
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
    private final static String GET_BOOKS_BY_STATUS_SQL = "SELECT * FROM books WHERE book_status = ?";
    private final static String UPDATE_BOOKS_BY_STATUS_SQL = "UPDATE books SET book_status=? WHERE book_id=?";

    @Override
    public List<Book> getAllBook() {
        return jdbcTemplate.query(GET_ALL_BOOKS_SQL, new BookRowMapper());
    }

    @Override
    public Book getBookById(long id) {
        return jdbcTemplate.query(GET_BOOKS_BY_ID_SQL, new Object[]{id}, new BookRowMapper()).stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Book> getBookByStatus(String status) {
        return jdbcTemplate.query(GET_BOOKS_BY_STATUS_SQL, new Object[]{status}, new BookRowMapper());
    }

    @Override
    public void updateBookByStatus(long id, BookUpdateDTO bookUpdateDTO) {
        jdbcTemplate.update(UPDATE_BOOKS_BY_STATUS_SQL, bookUpdateDTO.getStatus(), id);
    }
}
