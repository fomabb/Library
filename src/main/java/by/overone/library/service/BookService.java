package by.overone.library.service;

import by.overone.library.dto.BookDataDTO;
import by.overone.library.dto.BookUpdateDTO;
import by.overone.library.model.Status;

import java.util.List;

public interface BookService {

    List<BookDataDTO> getAllBook();

    BookDataDTO getBookById(long id);

    List<BookDataDTO> getBookByStatus(String status);

    void updateBookByStatus(long id, BookUpdateDTO bookUpdateDTO);
}
