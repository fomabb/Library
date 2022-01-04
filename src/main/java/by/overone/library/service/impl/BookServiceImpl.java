package by.overone.library.service.impl;

import by.overone.library.dao.BookDAO;
import by.overone.library.dto.BookDataDTO;
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
        List<BookDataDTO> books = bookDAO.getAllBook().stream()
                .map(book -> new BookDataDTO(book.getIdBook(), book.getTitleBook(), book.getGenreBook(),
                        book.getAuthor(), book.getStatus()))
                .collect(Collectors.toList());
        return books;
    }
}
