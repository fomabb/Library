package by.overone.library.model;

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
    private String user_login;

    @Column(nullable = false)
    private String user_password;

    @Column(unique = true)
    private String user_email;

    @Enumerated(value = EnumType.STRING)
    private Role user_role;

    @Enumerated(value = EnumType.STRING)
    private Status user_status;
}
