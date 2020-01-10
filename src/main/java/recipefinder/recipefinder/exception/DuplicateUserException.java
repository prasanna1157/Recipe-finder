package recipefinder.recipefinder.exception;

public class DuplicateUserException extends RuntimeException {
    public DuplicateUserException(String s) {
        super(s);
    }
}
