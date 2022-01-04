package by.overone.library.dto;

import by.overone.library.model.Genre;
import by.overone.library.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDataDTO {
    private long idBook;
    private String titleBook;
    private Genre genreBook;
    private String author;
    private Status status;
}
