package by.overone.library.model;

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

    private String user_details_name;

    private String user_details_surname;

    private String user_details_address;

    private String user_details_phonenumber;

}
