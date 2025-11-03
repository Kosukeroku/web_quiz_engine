package kosukeroku.web_quiz_engine.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class QuizRequest {

    public static final int ANSWER_COUNT = 4;



@NotBlank(message = "Title cannot be empty!")
    private String title;

    @NotBlank(message = "You cannot enter an empty question!")
    private String text;

    @Size(min = ANSWER_COUNT, max = ANSWER_COUNT,
            message = "Quiz must have exactly " + ANSWER_COUNT + " options")
    private List<String> options;

    @Min(value = 0, message = "Answer ID must be between 0 and " + (ANSWER_COUNT - 1))
    @Max(value = ANSWER_COUNT - 1, message = "Answer ID must be between 0 and " + (ANSWER_COUNT - 1))
    private int answer;
}
