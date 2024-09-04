package com.bookmanager.bookmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bookmanager.bookmanager.Entity.APIResponse;

@RestControllerAdvice
public class CustomExceptionHandler {
    
    @ExceptionHandler(value = ResourceNotFoundException.class)
    public APIResponse handleResourceNotFoundException(ResourceNotFoundException exception){
        APIResponse response = APIResponse.builder().status(HttpStatus.NOT_FOUND).message(exception.getMessage()).build();
        return response;
    }

    @ExceptionHandler(value = UnsupportedOperationException.class)
    public APIResponse handleUnsupportedOperationException(UnsupportedOperationException exception){
        APIResponse response = APIResponse.builder().status(HttpStatus.BAD_REQUEST).message(exception.getMessage()).build();
        return response;
    }
}
