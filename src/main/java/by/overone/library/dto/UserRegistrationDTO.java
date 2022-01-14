package by.overone.library.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationDTO {

    @NotEmpty(message = "The login must not be empty")
    @Size(min = 2, max = 30, message = "Login must be between 2 and 30 characters")
    private String login;

    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 5, message = "Password is too simple")
    @Min(value = 0, message = "Password cannot be negative")
    private String password;

    @NotEmpty(message = "The email must not be empty")
    @Email(message = "Email should be valid")
    private String email;
}
