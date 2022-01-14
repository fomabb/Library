package by.overone.library.dto;

import by.overone.library.model.UserDetails;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsDTO extends UserDetails {

    @NotEmpty(message = "The name must not be empty")
    @Size(min = 2, max = 15, message = "name must be between 2 and 15 characters")
    private String user_details_name;

    @NotEmpty(message = "The surname must not be empty")
    private String user_details_surname;


    private String user_details_address;


    private String user_details_phonenumber;


    private long users_user_id;
}
