package kosukeroku.web_quiz_engine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnswerResponse {
    boolean success;
    String feedback;
}
