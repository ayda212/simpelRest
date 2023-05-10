package com.simpel.restapi.simpelrestapi.interception;

import com.simpel.restapi.simpelrestapi.exception.ResponseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HanddleResponseException {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> hanndleCustomExceptions(ResponseException responseException){
        return ResponseEntity.badRequest().body(responseException.getMessage());
    }
}
