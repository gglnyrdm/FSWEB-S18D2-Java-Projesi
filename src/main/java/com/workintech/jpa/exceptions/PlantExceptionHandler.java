package com.workintech.jpa.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class PlantExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<PlantErrorResponse> handleException(PlantException plantException){
        PlantErrorResponse plantErrorResponse = new PlantErrorResponse(
                plantException.getStatus().value(),plantException.getMessage(),System.currentTimeMillis()
        );
        return new ResponseEntity<>(plantErrorResponse,plantException.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity handleBindExceptions(MethodArgumentNotValidException exception){
        List errorList = exception.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> {
                    log.error(fieldError.getField() + ": " + fieldError.getDefaultMessage());
                    Map<String, String> errors = new HashMap<>();
                    errors.put(fieldError.getField(),fieldError.getDefaultMessage());
                    return errors;
                }).collect(Collectors.toList());
        return ResponseEntity.badRequest().body(errorList);
    }

    @ExceptionHandler
    public ResponseEntity<PlantErrorResponse> handleException(Exception exception){
        PlantErrorResponse plantErrorResponse = new PlantErrorResponse(
                HttpStatus.BAD_REQUEST.value(), exception.getMessage(),System.currentTimeMillis()
        );
        return new ResponseEntity<>(plantErrorResponse,HttpStatus.BAD_REQUEST);
    }
}
