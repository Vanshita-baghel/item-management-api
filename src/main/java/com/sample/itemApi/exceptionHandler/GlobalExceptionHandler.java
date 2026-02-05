package com.sample.itemApi.exceptionHandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleItemNotFound(ItemNotFoundException ex){
        ErrorResponse errorRes= new ErrorResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorRes);
    }   

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleInvalidArgument(MethodArgumentNotValidException ex){
        Map<String, String> errors= new HashMap<>();
        ex.getBindingResult()
            .getFieldErrors()
            .forEach(error-> errors.put(error.getField(), error.getDefaultMessage()));
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
    
}
