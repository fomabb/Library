package by.overone.library.Exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String errorCode) {
        super(errorCode);
    }
}
