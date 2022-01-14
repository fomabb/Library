package by.overone.library.service.impl;

import by.overone.library.dao.BookDAO;
import by.overone.library.dto.BookAddDTO;
import by.overone.library.dto.BookDataDTO;
import by.overone.library.model.Book;
import by.overone.library.model.Genre;
import by.overone.library.model.Status;
import by.overone.library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookDAO bookDAO;

    @Override
    public List<BookDataDTO> getAllBook() {
        return bookDAO.getAllBook().stream()
                .map(book -> new BookDataDTO(book.getBook_id(), book.getBook_title(), book.getBook_genre(),
                        book.getBook_author(), book.getBook_status()))
                .collect(Collectors.toList());
    }

    @Override
    public BookDataDTO getBookById(long id) {
        BookDataDTO bookDataDTO = new BookDataDTO();
        Book book = bookDAO.getBookById(id);
        bookDataDTO.setIdBook(book.getBook_id());
        bookDataDTO.setTitleBook(book.getBook_title());
        bookDataDTO.setGenreBook(book.getBook_genre());
        bookDataDTO.setAuthor(book.getBook_author());
        bookDataDTO.setStatus(book.getBook_status());
        return bookDataDTO;
    }

    @Override
    public List<BookDataDTO> getBookByStatus(String status) {
        return bookDAO.getBookByStatus(status).stream()
                .map(book -> new BookDataDTO(book.getBook_id(), book.getBook_title(), book.getBook_genre(),
                        book.getBook_author(), book.getBook_status()))
                .collect(Collectors.toList());
    }

    @Override
    public void updateBookByStatus(long id) {
        getBookById(id);
        bookDAO.updateBookByStatus(id);
    }

    @Override
    public void deleteBook(long id) {
        getBookById(id);
        bookDAO.deleteBook(id);
    }

    @Override
    public void addBook(BookAddDTO bookAddDTO) {
        Book book = new Book();
        book.setBook_title(bookAddDTO.getBook_title());
        book.setBook_genre(bookAddDTO.getBook_genre());
        book.setBook_author(bookAddDTO.getBook_author());
        book.setBook_status(Status.valueOf(Status.ACTIVE.toString().toUpperCase(Locale.ROOT)));
        bookDAO.addBook(book);
    }
}
