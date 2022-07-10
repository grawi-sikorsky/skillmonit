package pl.jsikora.skillmonit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import pl.jsikora.skillmonit.dto.UserDTO;
import pl.jsikora.skillmonit.dto.UserRegisterDTO;
import pl.jsikora.skillmonit.mapper.UserMapper;
import pl.jsikora.skillmonit.models.User;
import pl.jsikora.skillmonit.models.UserRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    @SpyBean
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    private User USER_MOCK;
    private UserRegisterDTO USER_REGISTER_MOCK;

    @BeforeEach
    void prepare(){
        USER_REGISTER_MOCK = new UserRegisterDTO();
        USER_REGISTER_MOCK.setUsername("username");
        USER_REGISTER_MOCK.setEmail("email");
        USER_REGISTER_MOCK.setPassword("password");
        USER_REGISTER_MOCK.setFirstname("firstname");
        USER_REGISTER_MOCK.setLastname("lastname");

        USER_MOCK = new User();
        USER_MOCK.setUsername("username");
        USER_MOCK.setEmail("email");
        USER_MOCK.setPassword("password");
        USER_MOCK.setFirstname("firstname");
        USER_MOCK.setLastname("lastname");
        USER_MOCK.setUuid("uuid");
        USER_MOCK.setPhone("phone");
    }

    @Test
    void addUser_should_save_user() {
        // given
        User userToSave = userMapper.mapToUser(USER_REGISTER_MOCK);

        // when
        when(userRepository.save(any(User.class))).thenReturn(userToSave);
        UserDTO expectedUserDTO = userService.addUser(USER_REGISTER_MOCK);

        // then
        assertEquals(USER_REGISTER_MOCK.getUsername(), expectedUserDTO.getUsername());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void addUser_should_throw_exception_when_user_exists() {

        when(userRepository.findByUsername(USER_REGISTER_MOCK.getUsername())).thenReturn(USER_MOCK);

        assertThrows(RuntimeException.class, () -> {
            userService.addUser(USER_REGISTER_MOCK);
        });
    }
}