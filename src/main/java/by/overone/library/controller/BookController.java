package by.overone.library.controller;

import by.overone.library.dto.BookAddDTO;
import by.overone.library.dto.BookDataDTO;
import by.overone.library.dto.BookUpdateCountDTO;
import by.overone.library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
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
        return bookService.getBookByIdActive(id);
    }

    @GetMapping("/status")
    public List<BookDataDTO> readBookByStatus(@RequestParam String status) {
        return bookService.getBookByStatus(status);
    }

    @PutMapping("/status/{id}")
    public void updateBookByStatus(@PathVariable long id) {
        bookService.updateBookByStatus(id);
    }

    @PutMapping("/delete/{id}")
    public void deleteBook(@Validated @PathVariable long id) {
        bookService.deleteBook(id);
    }

    @PostMapping
    public void addBook(@Validated @RequestBody BookAddDTO bookAddDTO) {
        bookService.addBook(bookAddDTO);
    }

    @PutMapping("/count/{id}")
    public void updateBookCount(@Validated @PathVariable long id, @RequestBody BookUpdateCountDTO book) {
        bookService.updateBookCount(id, book);

    }
}
