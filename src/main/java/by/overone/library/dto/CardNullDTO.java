package by.overone.library.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardNullDTO {

    @Min(1)
    private long users_user_id;

    @Min(1)
    private long books_book_id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime date_of_receiving;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime delivery_date;
}
