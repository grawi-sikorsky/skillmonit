package pl.jsikora.skillmonit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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

    @MockBean
    private UserRegisterDTO USER_REGISTER_MOCK;

    @Autowired
    private UserService userService;

    @Test
    void addUser_should_add_user() {
        // given
        UserRegisterDTO testUserRequest = new UserRegisterDTO();
        testUserRequest.setUsername("username");
        testUserRequest.setEmail("email");
        testUserRequest.setPassword("password");
        testUserRequest.setFirstname("firstname");
        testUserRequest.setLastname("lastname");

        // when
        when(userRepository.findByUsername(testUserRequest.getUsername())).thenReturn(null);
        //when(userMapper.mapToUser(testUserRequest)).thenReturn(testUserRequest);
        UserDTO expectedUser = userService.addUser(testUserRequest);

        // then
        assertEquals(expectedUser.getUsername(), testUserRequest.getUsername());
    }
}
