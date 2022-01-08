package by.overone.library.dao;

import by.overone.library.dto.BookDataDTO;
import by.overone.library.dto.BookUpdateDTO;
import by.overone.library.model.Book;
import by.overone.library.model.Status;

import java.util.List;

public interface BookDAO {

    List<Book> getAllBook();

    Book getBookById(long id);

    List<Book> getBookByStatus(String status);

    void updateBookByStatus(long id, BookUpdateDTO bookUpdateDTO);
}
