package com.jiaul.virtualtutor.advice;

import com.jiaul.virtualtutor.customexception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String, String> handleValidationExceptions(UserNotFoundException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error message: ",ex.getMessage());
        return errors;
    }
}
