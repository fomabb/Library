package by.overone.library.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationDTO {

    @NotEmpty
    @Pattern(regexp = "^[\\w]{4,12}$")
    private String user_login;

    @NotEmpty
    @Pattern(regexp = "[a-zA-Z0-9]{2,16}")
    private String user_password;

    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,6}$")
    private String user_email;
}
