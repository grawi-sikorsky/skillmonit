package pl.jsikora.skillmonit.mapper;

import org.mapstruct.Mapper;

import pl.jsikora.skillmonit.dto.UserDTO;
import pl.jsikora.skillmonit.dto.UserRegisterDTO;
import pl.jsikora.skillmonit.models.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User mapToUser(UserRegisterDTO userRegisterDTO);

    UserDTO mapUserToUserDTO(User user);

}