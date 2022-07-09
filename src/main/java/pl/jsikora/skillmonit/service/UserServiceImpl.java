package pl.jsikora.skillmonit.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pl.jsikora.skillmonit.dto.UserDTO;
import pl.jsikora.skillmonit.dto.UserRegisterDTO;
import pl.jsikora.skillmonit.mapper.UserMapper;
import pl.jsikora.skillmonit.models.User;
import pl.jsikora.skillmonit.models.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO addUser(UserRegisterDTO userRegisterDTO) throws RuntimeException {
        User user = userMapper.mapToUser(userRegisterDTO);

        if (userRepository.findByUsername(user.getUsername()) == null) {
            user.setPassword(bCryptPasswordEncoder.encode(userRegisterDTO.getPassword()));
            return userMapper.mapUserToUserDTO(userRepository.save(user));
        }
        throw new RuntimeException("User probably exists..");
    }

}
