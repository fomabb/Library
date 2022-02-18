package by.overone.library.dto;

import by.overone.library.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookAddDTO {

    private String book_title;

    @Pattern(regexp = "^[\\w]{4,20}$")
    private String book_genre;

    private String book_author;

    private Status book_status;

    @Min(1)
    private long book_count;
}
