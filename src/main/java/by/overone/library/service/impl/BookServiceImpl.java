package by.overone.library.service.impl;

import by.overone.library.dao.BookDAO;
import by.overone.library.dto.BookDataDTO;
import by.overone.library.dto.BookUpdateDTO;
import by.overone.library.model.Book;
import by.overone.library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookDAO bookDAO;

    @Override
    public List<BookDataDTO> getAllBook() {
        return bookDAO.getAllBook().stream()
                .map(book -> new BookDataDTO(book.getIdBook(), book.getTitleBook(), book.getGenreBook(),
                        book.getAuthor(), book.getStatus()))
                .collect(Collectors.toList());
    }

    @Override
    public BookDataDTO getBookById(long id) {
        BookDataDTO bookDataDTO = new BookDataDTO();
        Book book = bookDAO.getBookById(id);
        bookDataDTO.setIdBook(book.getIdBook());
        bookDataDTO.setTitleBook(book.getTitleBook());
        bookDataDTO.setGenreBook(book.getGenreBook());
        bookDataDTO.setAuthor(book.getAuthor());
        bookDataDTO.setStatus(book.getStatus());
        return bookDataDTO;
    }

    @Override
    public List<BookDataDTO> getBookByStatus(String status) {
        return bookDAO.getBookByStatus(status).stream()
                .map(book -> new BookDataDTO(book.getIdBook(), book.getTitleBook(), book.getGenreBook(),
                        book.getAuthor(), book.getStatus()))
                .collect(Collectors.toList());
    }

    @Override
    public void updateBookByStatus(long id, BookUpdateDTO bookUpdateDTO) {
        getBookById(id);
        bookDAO.updateBookByStatus(id, bookUpdateDTO);
    }
}
