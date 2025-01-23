package com.funeraria.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.Map;

@RestControllerAdvice
public class ControllerException {

    @ExceptionHandler(EmailValidationException.class)
    public ResponseEntity<Map<String,String>> emailException(EmailValidationException emailException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap("ERROR",emailException.getMessage()));
    }

}
