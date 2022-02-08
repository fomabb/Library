package by.overone.library.dto;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDetailsDTO {

    @Pattern(regexp = "^[a-zA-Z]{2,30}$")
    private String user_details_name;

    @Pattern(regexp = "^[a-zA-Z]{2,30}$")
    private String user_details_surname;

    @Pattern(regexp = "^[\\w]{5,50}$")
    private String user_details_address;

    @Pattern(regexp = "^(\\+375|29)(17|29|33|44)(\\d){7}$")
    private String user_details_phonenumber;
}
