package by.overone.library.dao.mapper;

import by.overone.library.model.Book;
import by.overone.library.model.Genre;
import by.overone.library.model.Status;
import by.overone.library.util.constant.BookConstant;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public class BookRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setIdBook(rs.getLong(BookConstant.ID));
        book.setTitleBook(rs.getString(BookConstant.TITLE));
        book.setGenreBook(Genre.valueOf(rs.getString(BookConstant.GENRE).toUpperCase(Locale.ROOT)));
        book.setAuthor(rs.getString(BookConstant.AUTHOR));
        book.setStatus(Status.valueOf(rs.getString(BookConstant.STATUS)));
        return book;
    }
}
