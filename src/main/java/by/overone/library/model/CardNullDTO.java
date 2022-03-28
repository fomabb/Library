package by.overone.library.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardNullDTO {

    private long users_user_id;

    private long books_book_id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime date_of_receiving;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime delivery_date;
}
