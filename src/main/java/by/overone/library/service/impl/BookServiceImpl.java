package by.overone.library.service.impl;

import by.overone.library.dao.BookDAO;
import by.overone.library.dto.BookAddDTO;
import by.overone.library.dto.BookDataDTO;
import by.overone.library.dto.BookUpdateCountDTO;
import by.overone.library.exception.EntityNotFoundException;
import by.overone.library.exception.ExceptionCode;
import by.overone.library.model.Book;
import by.overone.library.model.Status;
import by.overone.library.service.BookService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookDAO bookDAO;

    @Override
    public List<BookDataDTO> getAllBook() {
        return bookDAO.getAllBook().stream()
                .map(book -> new BookDataDTO(book.getBook_id(), book.getBook_title(), book.getBook_genre(),
                        book.getBook_author(), book.getBook_status(), book.getBook_count()))
                .collect(Collectors.toList());
    }

    @Override
    public BookDataDTO getBookByIdActive(long id) {
        BookDataDTO bookDataDTO = new BookDataDTO();
        Book book = bookDAO.getBookByIdActive(id).orElseThrow(() -> new EntityNotFoundException(ExceptionCode.NOT_EXISTING_BOOK.getErrorCode()));
        bookDataDTO.setIdBook(book.getBook_id());
        bookDataDTO.setTitleBook(book.getBook_title());
        bookDataDTO.setGenreBook(book.getBook_genre());
        bookDataDTO.setAuthor(book.getBook_author());
        bookDataDTO.setStatus(book.getBook_status());
        bookDataDTO.setBook_count(book.getBook_count());
        return bookDataDTO;
    }

    @Override
    public BookDataDTO getBookById(long id) {
        log.info("Get book by id " + id + " service method started");
        BookDataDTO bookDataDTO = new BookDataDTO();
        Book book = bookDAO.getBookById(id).orElseThrow(() -> new EntityNotFoundException(ExceptionCode.NOT_EXISTING_BOOK.getErrorCode()));
        bookDataDTO.setIdBook(book.getBook_id());
        bookDataDTO.setTitleBook(book.getBook_title());
        bookDataDTO.setGenreBook(book.getBook_genre());
        bookDataDTO.setAuthor(book.getBook_author());
        bookDataDTO.setStatus(book.getBook_status());
        bookDataDTO.setBook_count(book.getBook_count());
        return bookDataDTO;
    }


    @Override
    public List<BookDataDTO> getBookByStatus(String status) {
        return bookDAO.getBookByStatus(status).stream()
                .map(book -> new BookDataDTO(book.getBook_id(), book.getBook_title(), book.getBook_genre(),
                        book.getBook_author(), book.getBook_status(), book.getBook_count()))
                .collect(Collectors.toList());
    }

    @Override
    public void updateBookByStatus(long id) {
        getBookByIdActive(id);
        bookDAO.updateBookByStatus(id);
    }

    @Override
    public void deleteBook(long id) {
        getBookByIdActive(id);
        bookDAO.deleteBook(id);
    }

    @Override
    public void addBook(BookAddDTO bookAddDTO) {
        Book book = new Book();
        book.setBook_title(bookAddDTO.getBook_title());
        book.setBook_genre(bookAddDTO.getBook_genre());
        book.setBook_author(bookAddDTO.getBook_author());
        book.setBook_status(Status.valueOf(Status.ACTIVE.toString().toUpperCase(Locale.ROOT)));
        book.setBook_count(bookAddDTO.getBook_count());
        bookDAO.addBook(book);
    }

    @Override
    public void updateBookCount(long id, BookUpdateCountDTO bookUpdateCountDTO) {
        getBookByIdActive(id);
        if (bookUpdateCountDTO.getBook_count() <= 0) {
            bookUpdateCountDTO.setBook_status(Status.valueOf(Status.INACTIVE.toString().toUpperCase(Locale.ROOT)));
        } else {
            bookUpdateCountDTO.setBook_status(Status.valueOf(Status.ACTIVE.toString().toUpperCase(Locale.ROOT)));
        }
        bookDAO.updateBookCount(id, bookUpdateCountDTO);
    }

    @Override
    public BookDataDTO getBookIdInactive(long id) {
        BookDataDTO bookDataDTO = new BookDataDTO();
        Book book = bookDAO.getBookByIdInactive(id).orElseThrow(() -> new EntityNotFoundException(ExceptionCode.NOT_EXISTING_BOOK.getErrorCode()));
        bookDataDTO.setIdBook(book.getBook_id());
        bookDataDTO.setTitleBook(book.getBook_title());
        bookDataDTO.setGenreBook(book.getBook_genre());
        bookDataDTO.setAuthor(book.getBook_author());
        bookDataDTO.setStatus(book.getBook_status());
        bookDataDTO.setBook_count(book.getBook_count());
        return bookDataDTO;
    }
}
