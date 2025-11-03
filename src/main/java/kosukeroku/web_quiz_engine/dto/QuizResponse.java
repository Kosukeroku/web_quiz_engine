package kosukeroku.web_quiz_engine.dto;

import lombok.Data;

import java.util.List;

@Data
public class QuizResponse {

    private Long id;
    private String title;
    private String text;
    private List<String> options;
}
