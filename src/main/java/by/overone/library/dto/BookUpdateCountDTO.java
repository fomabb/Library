package by.overone.library.dto;

import by.overone.library.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookUpdateCountDTO {

    @NotEmpty
    @Min(0)
    private long book_count;

    private Status book_status;
}
