package by.overone.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private long book_id;
    private String book_title;
    private String book_genre;
    private String book_author;
    private Status book_status;
    private long book_count;
}
