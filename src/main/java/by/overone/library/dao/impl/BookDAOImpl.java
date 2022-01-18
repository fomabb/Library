package by.overone.library.dao.impl;

import by.overone.library.dao.BookDAO;
import by.overone.library.dao.mapper.BookRowMapper;
import by.overone.library.model.Book;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class BookDAOImpl implements BookDAO {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final static String GET_ALL_BOOKS_SQL = "SELECT * FROM bibliophile.books";
    private final static String GET_BOOKS_BY_ID_SQL = "SELECT * FROM books WHERE book_id=?";
    private final static String GET_BOOKS_BY_STATUS_SQL = "SELECT * FROM books WHERE book_status=?";
    private final static String UPDATE_BOOKS_BY_STATUS_SQL = "UPDATE books SET book_status= 'ACTIVE' WHERE book_id=?";
    private final static String DELETE_BOOKS_SQL = "UPDATE books SET book_status= 'INACTIVE' WHERE book_id=?";
    //    private final static String ADD_BOOKS_BY_ID_SQL = "INSERT INTO(book_title, book_genre, book_author, book_status)" +
//            "VALUES(:book_title, :book_genre, :book_author, :book_status)";
    private final static String ADD_BOOKS_BY_ID_SQL = "INSERT INTO books VALUES(0,?,?,?,?)";

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
                book.getBook_status().toString());
        System.out.println(book);
    }
}
