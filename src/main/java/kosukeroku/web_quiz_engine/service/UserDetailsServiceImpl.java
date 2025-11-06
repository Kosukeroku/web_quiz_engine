package kosukeroku.web_quiz_engine.service;

import kosukeroku.web_quiz_engine.model.User;
import kosukeroku.web_quiz_engine.repository.UserRepository;
import kosukeroku.web_quiz_engine.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private static final String USER_NOT_FOUND_MESSAGE = "Cannot find user with email: ";

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info("Loading user by email: {}", email);
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> {
                    log.error("User not found: {}", email);
                    return new UsernameNotFoundException(USER_NOT_FOUND_MESSAGE + email);
                });

        log.info("User found: {}", user.getEmail());
        return new UserPrincipal(user);
    }

}
