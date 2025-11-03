package kosukeroku.web_quiz_engine.controller;

import jakarta.validation.Valid;
import kosukeroku.web_quiz_engine.dto.QuizRequest;
import kosukeroku.web_quiz_engine.dto.QuizResponse;
import kosukeroku.web_quiz_engine.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;


    @PostMapping("/api/quizzes")
    @ResponseStatus(HttpStatus.CREATED)
    public QuizResponse addQuiz(@Valid @RequestBody QuizRequest quizRequest) {
        return quizService.saveQuiz(quizRequest);
    }

    @GetMapping("/api/quizzes/{id}")
    public QuizResponse getQuizById(@PathVariable Long id) {
            return quizService.getQuizById(id);
    }

}
