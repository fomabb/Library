package by.overone.library.dto;

import by.overone.library.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookUpdateCountDTO {
    private long book_count;
    private Status book_status;
}
