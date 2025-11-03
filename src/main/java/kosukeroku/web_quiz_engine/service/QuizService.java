package kosukeroku.web_quiz_engine.service;

import kosukeroku.web_quiz_engine.dto.QuizRequest;
import kosukeroku.web_quiz_engine.dto.QuizResponse;
import kosukeroku.web_quiz_engine.exception.QuizNotFoundException;
import kosukeroku.web_quiz_engine.mapper.QuizMapper;
import kosukeroku.web_quiz_engine.model.Quiz;
import kosukeroku.web_quiz_engine.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;
    private final QuizMapper quizMapper;

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
                .orElseThrow(() -> new QuizNotFoundException("Cannot find quiz with id " + id));

    }
}

