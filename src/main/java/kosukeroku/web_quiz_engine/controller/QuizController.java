    package kosukeroku.web_quiz_engine.controller;

    import jakarta.validation.Valid;
    import jakarta.validation.constraints.Max;
    import jakarta.validation.constraints.Min;
    import kosukeroku.web_quiz_engine.dto.AnswerResponse;
    import kosukeroku.web_quiz_engine.dto.QuizRequest;
    import kosukeroku.web_quiz_engine.dto.QuizResponse;
    import kosukeroku.web_quiz_engine.service.QuizService;
    import lombok.RequiredArgsConstructor;
    import org.springframework.http.HttpStatus;
    import org.springframework.validation.annotation.Validated;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    import static kosukeroku.web_quiz_engine.dto.QuizRequest.ANSWER_COUNT;

    @RestController
    @RequiredArgsConstructor
    @Validated
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

        @GetMapping("/api/quizzes")
        public List<QuizResponse> getAllQuizzes() {
            return quizService.getAllQuizzes();
        }

        @PostMapping("/api/quizzes/{id}/solve")
        public AnswerResponse solveQuiz(
                @PathVariable Long id,
                @RequestParam
                @Min(value = 0, message = "Answer ID must be between 0 and " + (ANSWER_COUNT - 1))
                @Max(value = ANSWER_COUNT - 1, message = "Answer ID must be between 0 and " + (ANSWER_COUNT - 1))
                int answer) {

            return quizService.solveQuiz(answer, id);
        }

    }
