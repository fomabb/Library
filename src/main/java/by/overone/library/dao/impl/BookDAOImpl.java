package by.overone.library.dao.impl;

import by.overone.library.dao.BookDAO;
import by.overone.library.dto.BookUpdateCountDTO;
import by.overone.library.mapper.BookRowMapper;
import by.overone.library.model.Book;
import by.overone.library.model.Status;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class BookDAOImpl implements BookDAO {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final static String GET_ALL_BOOKS_SQL = "SELECT * FROM bibliophile.books";
    private final static String GET_BOOKS_BY_ID_ACTIVE_SQL = "SELECT * FROM books WHERE book_id=? AND book_status='ACTIVE'";
    private final static String GET_BOOKS_BY_ID_INACTIVE_SQL = "SELECT * FROM books WHERE book_id=? AND book_status='INACTIVE'";
    private final static String GET_BOOKS_BY_ID_SQL = "SELECT * FROM books WHERE book_id=?";
    private final static String GET_BOOKS_BY_STATUS_SQL = "SELECT * FROM books WHERE book_status=?";
    private final static String UPDATE_BOOKS_BY_STATUS_SQL = "UPDATE books SET book_status= 'ACTIVE' WHERE book_id=?";
    private final static String DELETE_BOOKS_SQL = "UPDATE books SET book_status= 'INACTIVE' WHERE book_id=?";
    private final static String ADD_BOOKS_BY_ID_SQL = "INSERT INTO books VALUES(0,?,?,?,?,?)";
    private final static String UPDATE_BOOK_COUNT_SQL = "UPDATE books SET book_count=?, book_status=? WHERE book_id=?";

    @Override
    public List<Book> getAllBook() {
        return jdbcTemplate.query(GET_ALL_BOOKS_SQL, new BookRowMapper());
    }

    @Override
    public Optional<Book> getBookByIdActive(long id) {
        return jdbcTemplate.query(GET_BOOKS_BY_ID_ACTIVE_SQL, new Object[]{id}, new BookRowMapper())
                .stream()
                .findAny();
    }

    @Override
    public Optional<Book> getBookById(long id) {
        return jdbcTemplate.query(GET_BOOKS_BY_ID_SQL, new Object[]{id}, new BookRowMapper())
                .stream()
                .findAny();
    }

    @Override
    public List<Book> getBookByStatus(String status) {
        return jdbcTemplate.query(GET_BOOKS_BY_STATUS_SQL, new Object[]{status}, new BookRowMapper());
    }

    @Override
    public void updateBookByStatus(long id) {
        jdbcTemplate.update(UPDATE_BOOKS_BY_STATUS_SQL, id);
    }

    @Override
    public void deleteBook(long id) {
        jdbcTemplate.update(DELETE_BOOKS_SQL, id);
    }

    @Override
    public void addBook(Book book) {
        jdbcTemplate.update(ADD_BOOKS_BY_ID_SQL, book.getBook_title(), book.getBook_genre(), book.getBook_author(),
                book.getBook_status().toString(), book.getBook_count());
    }

    @Override
    public void updateBookCount(long id, BookUpdateCountDTO bookUpdateCountDTO) {
        jdbcTemplate.update(UPDATE_BOOK_COUNT_SQL, bookUpdateCountDTO.getBook_count(),
                bookUpdateCountDTO.getBook_status().toString(), id);
    }

    @Override
    public void updateBookCounter(long id, long count) {
        BookUpdateCountDTO bookUpdateCountDTO = new BookUpdateCountDTO();
        getBookByIdActive(id);
        if (count <= 0) {
            bookUpdateCountDTO.setBook_status(Status.valueOf(Status.INACTIVE.toString().toUpperCase(Locale.ROOT)));
        } else {
            bookUpdateCountDTO.setBook_status(Status.valueOf(Status.ACTIVE.toString().toUpperCase(Locale.ROOT)));
        }
        jdbcTemplate.update(UPDATE_BOOK_COUNT_SQL, count, bookUpdateCountDTO.getBook_status().toString(), id);
    }


    @Override
    public Optional<Book> getBookByIdInactive(long id) {
        return jdbcTemplate.query(GET_BOOKS_BY_ID_INACTIVE_SQL, new Object[]{id}, new BookRowMapper())
                .stream()
                .findAny();
    }
}