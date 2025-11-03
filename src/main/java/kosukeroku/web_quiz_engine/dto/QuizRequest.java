package kosukeroku.web_quiz_engine.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class QuizRequest {

    @NotBlank(message = "Title cannot be empty!")
    private String title;

    @NotBlank(message = "You cannot enter an empty question!")
    private String text;

    @Size(min = 2, message = "Quiz must have at least two answer options.")
    private List<String> options;

    private long answerId;
}
