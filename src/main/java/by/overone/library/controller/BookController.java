package by.overone.library.controller;

import by.overone.library.dto.BookDataDTO;
import by.overone.library.dto.BookUpdateDTO;
import by.overone.library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public BookDataDTO readBookById(@PathVariable long id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/status/{status}")
    public List<BookDataDTO> readBookByStatus(@PathVariable String status) {
        return bookService.getBookByStatus(status);
    }

    @PutMapping("/{id}")
    public void updateBookByStatus(@PathVariable long id, @RequestBody BookUpdateDTO book) {
        bookService.updateBookByStatus(id, book);
    }
}
