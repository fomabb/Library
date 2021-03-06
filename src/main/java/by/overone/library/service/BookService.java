package by.overone.library.service;

import by.overone.library.dto.BookAddDTO;
import by.overone.library.dto.BookDataDTO;
import by.overone.library.dto.BookUpdateCountDTO;

import java.util.List;

public interface BookService {

    List<BookDataDTO> getAllBook();

    BookDataDTO getBookByIdActive(long id);

    BookDataDTO getBookById(long id);

    List<BookDataDTO> getBookByStatus(String status);

    void updateBookByStatus(long id);

    void deleteBook(long id);

    void addBook(BookAddDTO bookAddDTO);

    void updateBookCount(long id, BookUpdateCountDTO bookUpdateCountDTO);

    BookDataDTO getBookIdInactive(long id);
}
