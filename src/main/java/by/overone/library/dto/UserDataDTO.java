package by.overone.library.dto;

import by.overone.library.model.Role;
import by.overone.library.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDataDTO {
    private long id;
    private String login;
    private String email;
    private Role role;
    private Status status;
}
