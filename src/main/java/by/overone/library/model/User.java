package by.overone.library.model;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;

    @Column(unique = true)
    @Pattern(regexp = "^[\\w]{4,12}$", message = "Incorrect input")
    private String user_login;

    @Column(nullable = false)
    @Pattern(regexp = "[a-zA-Z0-9]{2,16}", message = "Incorrect input")
    private String user_password;

    @Column(unique = true)
    @Pattern(regexp = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,6}$", message = "Incorrect input")
    private String user_email;

    @Enumerated(value = EnumType.STRING)
    private Role user_role;

    @Enumerated(value = EnumType.STRING)
    private Status user_status;

//    @JoinColumn(name = "users_user_id")
//    @OneToOne(cascade = CascadeType.ALL)
//    private UserDetails userDetails;
}
