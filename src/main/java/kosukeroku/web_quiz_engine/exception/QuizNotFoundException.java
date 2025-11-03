package kosukeroku.web_quiz_engine.exception;


public class QuizNotFoundException extends RuntimeException {

    public QuizNotFoundException(String message) {
        super(message);
    }
}
