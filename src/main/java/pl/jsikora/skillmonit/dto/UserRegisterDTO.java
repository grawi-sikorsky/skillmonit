package pl.jsikora.skillmonit.dto;

import javax.validation.constraints.NotNull;

import pl.jsikora.skillmonit.models.User;

public class UserRegisterDTO {

    @NotNull( message = "Username is required")
    private String username;

    @NotNull(message = "Password is required")
    private String password;

    @NotNull(message = "Email is required")
    private String email;

    @NotNull(message = "Firstname is required")
    private String firstname;

    @NotNull(message = "Lastname is required")
    private String lastname;

    UserRegisterDTO(User user){
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
    }
}
