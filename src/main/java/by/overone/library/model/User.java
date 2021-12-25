package by.overone.library.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private long user_id;
    private String user_login;
    private String user_password;
    private String user_email;
    private String user_role;
    private String user_status;
}
