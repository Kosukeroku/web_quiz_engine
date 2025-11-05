package kosukeroku.web_quiz_engine.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequest {

    @Email(message = "Email is invalid")
    @NotBlank(message = "Email is required")
    private String email;

    @Min(value = 8, message = "Password must have at least 8 characters")
    private String password;
}
