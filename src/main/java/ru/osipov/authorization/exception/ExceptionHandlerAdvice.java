package ru.osipov.authorization.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> handleUnauthorizedUser(UnauthorizedUser e) {
        System.out.println("Неправильно введены имя пользователя или пароль: " + e.getMessage());
        return new ResponseEntity<>("Неправильно введены имя пользователя или пароль: " + e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<String> handleNotValidInput(ValidationException e) {
        return new ResponseEntity<>("Косячные имя пользователя или пароль:\r\n" + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}