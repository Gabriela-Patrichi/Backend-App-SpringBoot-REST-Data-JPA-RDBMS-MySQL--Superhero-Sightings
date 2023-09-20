package com.SuperheroSightings.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

//here we will deal with all exceptions
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    //Exception handler using the ApplicationException class defined in the same package
    @ExceptionHandler(value= {ApplicationException.class})
    public ResponseEntity<ErrorDto> handleApplicationException(ApplicationException ae, WebRequest request) {
        ErrorDto error = new ErrorDto(ae.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());
        return new ResponseEntity<ErrorDto>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}