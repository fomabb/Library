package by.overone.library.Exception;

public enum ExceptionCode {
    NOT_EXISTING_USER("4000"),
    NOT_EXISTING_BOOK("4001");

    private final String errorCode;

    ExceptionCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
