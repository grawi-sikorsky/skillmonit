package pl.jsikora.skillmonit.service;

import pl.jsikora.skillmonit.dto.UserDTO;
import pl.jsikora.skillmonit.dto.UserRegisterDTO;

public interface UserService {

    UserDTO addUser(UserRegisterDTO user);

}
