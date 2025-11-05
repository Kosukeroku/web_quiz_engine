package kosukeroku.web_quiz_engine.exception;

public class UserAlreadyExistsException extends RuntimeException {

    private static final String USER_ALREADY_EXISTS_MESSAGE = "User with this email already exists";

    public UserAlreadyExistsException() {
        super(USER_ALREADY_EXISTS_MESSAGE);
    }

}
