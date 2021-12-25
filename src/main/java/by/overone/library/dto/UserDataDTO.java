package by.overone.library.dto;

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
    private String role;
    private String status;
}
