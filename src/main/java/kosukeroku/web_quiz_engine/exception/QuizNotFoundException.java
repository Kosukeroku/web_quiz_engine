package kosukeroku.web_quiz_engine.exception;


public class QuizNotFoundException extends RuntimeException {

    private static final String NOT_FOUND_MESSAGE = "Cannot find a quiz with id: ";


    public QuizNotFoundException(Long id) {
        super(NOT_FOUND_MESSAGE + id);
    }
}
