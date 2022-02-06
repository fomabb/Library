package by.overone.library.dto;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationDTO {

    @Pattern(regexp = "^[\\w]{4,12}$")
    private String user_login;

    @Pattern(regexp = "[a-zA-Z0-9]{2,16}")
    private String user_password;

    @Pattern(regexp = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,6}$")
    private String user_email;
}
