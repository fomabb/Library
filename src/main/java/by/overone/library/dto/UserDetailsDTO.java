package by.overone.library.dto;

import by.overone.library.model.UserDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsDTO extends UserDetails {

    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z]{2,30}$")
    private String user_details_name;

    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z]{2,30}$")
    private String user_details_surname;

    @NotEmpty
    @Pattern(regexp = "^[\\w]{2,50}$")
    private String user_details_address;

    @NotEmpty
    @Pattern(regexp = "^(\\+375|29)(17|29|33|44)(\\d){7}$")
    private String user_details_phonenumber;


    private long users_user_id;
}
