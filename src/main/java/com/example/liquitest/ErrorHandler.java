package com.example.liquitest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    public static final String APPLY_DATA_ERROR_MESSAGE = "Error applying data migration script";

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<Object> handleError(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, APPLY_DATA_ERROR_MESSAGE, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
