package by.overone.library.dao;

import by.overone.library.model.Book;

import java.util.List;

public interface BookDAO {

    List<Book> getAllBook();

    Book getBookById(long id);

    List<Book> getBookByStatus(String status);

    void updateBookByStatus(long id);

    void deleteBook(long id);

    void addBook(Book book);
}
