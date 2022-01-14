package by.overone.library.model;


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
public class User {
    private long user_id;

    @NotEmpty(message = "The name must not be empty")
    @Size(min = 2, max = 30 , message = "Name must be between 2 and 30 characters")
    private String user_login;

    @NotEmpty(message = "Password cannot be empty")
    @Min(value = 0, message = "Password cannot be negative")
    private String user_password;

    @NotEmpty(message = "The email must not be empty")
    @Email(message = "Email should be valid")
    private String user_email;

    private Role user_role;
    private Status user_status;
}
