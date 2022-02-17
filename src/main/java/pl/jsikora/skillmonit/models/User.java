package pl.jsikora.skillmonit.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class User {

    @Id
    String id;
    String username;
    String password;
    String firstname;
    String lastname;
}
