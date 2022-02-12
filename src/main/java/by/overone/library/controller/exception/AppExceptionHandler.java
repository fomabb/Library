package by.overone.library.controller.exception;

import by.overone.library.Exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionResponse> entityNotFoundHandler(EntityNotFoundException e) {
        ExceptionResponse response = new ExceptionResponse();
        response.setException(e.getClass().getName());
        response.setErrorCode(e.getMessage());

        String message = "";
        switch (e.getMessage()) {
            case "4000" : message = "User Not Found";
            break;
            case "4001" : message = "Book Not Found";
            break;
        }

        response.setMessage(message);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(SQLException.class)
//    public void handleEntityNotFound() {
//        "sorry aplication is non avalible"
//    }
}
