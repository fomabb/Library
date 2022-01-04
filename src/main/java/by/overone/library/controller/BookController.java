package by.overone.library.controller;

import by.overone.library.dto.BookDataDTO;
import by.overone.library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<BookDataDTO> readAll() {
        return bookService.getAllBook();
    }
}
