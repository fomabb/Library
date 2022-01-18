package by.overone.library.dto;

import by.overone.library.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookAddDTO {
    private String book_title;
    private String book_genre;
    private String book_author;
    private Status book_status;
}
