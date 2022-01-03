package by.overone.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {
    private String user_details_name;
    private String user_details_surname;
    private String user_details_address;
    private String user_details_phonenumber;
    private long users_user_id;
}
