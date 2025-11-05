package kosukeroku.web_quiz_engine.service;


import kosukeroku.web_quiz_engine.dto.UserRequest;
import kosukeroku.web_quiz_engine.dto.UserResponse;
import kosukeroku.web_quiz_engine.exception.UserAlreadyExistsException;
import kosukeroku.web_quiz_engine.mapper.UserMapper;
import kosukeroku.web_quiz_engine.model.User;
import kosukeroku.web_quiz_engine.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserResponse register(UserRequest userRequest) {

        log.info("Registering user: {}", userRequest.getEmail());

        if (userRepository.existsByEmail(userRequest.getEmail())) {
            throw new UserAlreadyExistsException();
        }

        User user = userMapper.toEntity(userRequest);
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        userRepository.save(user);

        log.info("User saved with id: {}", user.getId());

        return userMapper.toResponse(user);
    }
}
