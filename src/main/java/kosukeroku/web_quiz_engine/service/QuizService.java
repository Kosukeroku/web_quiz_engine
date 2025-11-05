package kosukeroku.web_quiz_engine.service;

import kosukeroku.web_quiz_engine.dto.AnswerResponse;
import kosukeroku.web_quiz_engine.dto.QuizRequest;
import kosukeroku.web_quiz_engine.dto.QuizResponse;
import kosukeroku.web_quiz_engine.exception.QuizNotFoundException;
import kosukeroku.web_quiz_engine.mapper.QuizMapper;
import kosukeroku.web_quiz_engine.model.Quiz;
import kosukeroku.web_quiz_engine.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;
    private final QuizMapper quizMapper;

    private static final String RIGHT_RESPONSE_MESSAGE = "Congratulations, you're right!";
    private static final String WRONG_RESPONSE_MESSAGE = "Wrong answer! Please, try again.";

    public QuizResponse saveQuiz(QuizRequest quizRequest) {
        log.info("Creating quiz: {}", quizRequest.getTitle());

        Quiz newQuiz = quizMapper.toEntity(quizRequest);
        newQuiz = quizRepository.save(newQuiz);

        log.info("Quiz saved with id: {}", newQuiz.getId());

        return quizMapper.toResponse(newQuiz);
    }

    public QuizResponse getQuizById(Long id) {
        log.info("Getting quiz by id: {}", id);
        return quizRepository.findById(id)
                .map(quizMapper::toResponse)
                .orElseThrow(() -> new QuizNotFoundException(id));

    }

    public List<QuizResponse> getAllQuizzes() {
        log.info("Getting all quizzes");
        return quizRepository.findAll()
                .stream()
                .map(quizMapper::toResponse)
                .collect(Collectors.toList());
    }

    public AnswerResponse solveQuiz(int answer, Long quizId) {
        log.info("Solving quiz with id: {}", quizId);
        Quiz quiz = quizRepository.findById(quizId)
                        .orElseThrow(() -> new QuizNotFoundException(quizId));

        boolean isCorrect = answer == quiz.getAnswer();
        log.info("Answer is correct: {}", isCorrect);
        String message = isCorrect ? RIGHT_RESPONSE_MESSAGE : WRONG_RESPONSE_MESSAGE;

        return new AnswerResponse(isCorrect, message);
    }
}

