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
    private long user_id;
    private String user_login;
    private String user_email;
    private Role user_role;
    private Status user_status;
}
