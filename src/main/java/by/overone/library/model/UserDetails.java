package by.overone.library.model;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {

    @Id
    private long users_user_id;

    @Pattern(regexp = "^[a-zA-Z]{2,30}$", message = "Incorrect input")
    private String user_details_name;

    @Pattern(regexp = "^[a-zA-Z]{2,30}$", message = "Incorrect input")
    private String user_details_surname;

    @Pattern(regexp = "^[\\w]{5,50}$", message = "Incorrect input")
    private String user_details_address;

    @Pattern(regexp = "^(\\+375|29)(17|29|33|44)(\\d){7}$", message = "Incorrect input")
    private String user_details_phonenumber;

}
