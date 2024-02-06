package com.eventapplication.eventapplication.exceptions;

import com.eventapplication.eventapplication.common.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseBuilder> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {


        return new ResponseEntity<>(new ResponseBuilder().setMassage(ex.getMessage()).setStatus(HttpStatus.NOT_FOUND.value()).build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseBuilder> globalExceptionHandler(Exception ex, WebRequest request) {


        return new ResponseEntity<>(new ResponseBuilder().setMassage(ex.getMessage()).setStatus(HttpStatus.NOT_FOUND.value()).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
