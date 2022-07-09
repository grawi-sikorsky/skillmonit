package pl.jsikora.skillmonit.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import pl.jsikora.skillmonit.dto.UserRegisterDTO;
import pl.jsikora.skillmonit.mapper.UserMapper;
import pl.jsikora.skillmonit.models.User;
import pl.jsikora.skillmonit.models.UserRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @Mock
    private User USER_MOCK;

    @Mock
    private UserRegisterDTO USER_REGISTER_MOCK;

    @InjectMocks
    private UserService userService;

    @Test
    void addUser_should_add_user(){
        //given
        //UserRegisterDTO testUser = userMapper.map new User(USER_MOCK);

        //when
        when( userRepository.findByUsername(USER_REGISTER_MOCK.getUsername()) ).thenReturn(null);

        //then
        a
    }
}
