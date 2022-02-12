package by.overone.library.dto;

import by.overone.library.model.Status;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookAddDTO {

    private String book_title;

    private String book_genre;

    @Pattern(regexp = "^[\\w]{4,12}$")
    private String book_author;

    private Status book_status;

    private long book_count;
}
