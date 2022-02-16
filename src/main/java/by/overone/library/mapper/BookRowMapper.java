package by.overone.library.mapper;

import by.overone.library.model.Book;
import by.overone.library.model.Status;
import by.overone.library.util.constant.BookConstant;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setBook_id(rs.getLong(BookConstant.ID));
        book.setBook_title(rs.getString(BookConstant.TITLE));
        book.setBook_genre(rs.getString(BookConstant.GENRE));
        book.setBook_author(rs.getString(BookConstant.AUTHOR));
        book.setBook_status(Status.valueOf(rs.getString(BookConstant.STATUS)));
        book.setBook_count(rs.getLong(BookConstant.COUNT));
        return book;
    }
}
