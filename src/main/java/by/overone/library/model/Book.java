package by.overone.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private long idBook;
    private String titleBook;
    private Genre genreBook;
    private String author;
    private Status status;
}
