package kosukeroku.web_quiz_engine.controller;

import jakarta.validation.Valid;
import kosukeroku.web_quiz_engine.dto.UserRequest;
import kosukeroku.web_quiz_engine.dto.UserResponse;
import kosukeroku.web_quiz_engine.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/api/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse register(@Valid @RequestBody UserRequest userRequest) {
        return userService.register(userRequest);
    }
}

