package by.overone.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDataDTO {

    @Min(1)
    private long users_user_id;

    @Min(1)
    private long books_book_id;
}
