package pl.jsikora.skillmonit.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 255)
    @Column(name = "uuid", unique = true, nullable = false)
    private String uuid;

    @Size(max = 50)
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Size(max = 255)
    @Column(name = "password", nullable = false)
    private String password;

    @Size(max = 255)
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Size(max = 255)
    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Size(max = 255)
    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Size(max = 20)
    @Column(name = "phone", nullable = false)
    private String phone;

    @PrePersist
    public void prepersist() {
        this.uuid = UUID.randomUUID().toString();
    }

    public User() {
    }

    public User(User inUser) {
        this.id = inUser.id;
        this.uuid = inUser.uuid;
        this.username = inUser.username;
        this.password = inUser.password;
        this.email = inUser.email;
        this.firstname = inUser.firstname;
        this.lastname = inUser.lastname;
        this.phone = inUser.phone;
    }
}
