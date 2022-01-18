package by.overone.library.controller.exception;

import lombok.Data;

@Data
public class ExceptionResponse {
    private String exception;
    private String message;
    private String errorCode;
}
