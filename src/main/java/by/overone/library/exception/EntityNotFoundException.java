package by.overone.library.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String errorCode) {
        super(errorCode);
    }
}
