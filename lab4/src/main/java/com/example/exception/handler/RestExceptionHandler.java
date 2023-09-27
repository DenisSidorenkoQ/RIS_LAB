package com.example.exception.handler;

import com.example.entity.response.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler({EntityNotFoundException.class})
    @ResponseStatus(value = NOT_FOUND)
    public ErrorResponse handleEntityNotFoundException(
            final EntityNotFoundException ex, final WebRequest request) {
        return new ErrorResponse(NOT_FOUND.value(), ex.getMessage(), request.getDescription(false));
    }

    @ExceptionHandler({EntityExistsException.class})
    @ResponseStatus(value = CONFLICT)
    public ErrorResponse handleEntityExistsException(
            final EntityExistsException ex, final WebRequest request) {
        return new ErrorResponse(CONFLICT.value(), ex.getMessage(), request.getDescription(false));
    }
}
