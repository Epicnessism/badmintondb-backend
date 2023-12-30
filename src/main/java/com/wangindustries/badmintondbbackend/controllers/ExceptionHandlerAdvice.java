package com.wangindustries.badmintondbbackend.controllers;


import com.wangindustries.badmintondbbackend.Exceptions.SignInCredentialsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);
     @ExceptionHandler(SignInCredentialsException.class)
     public ResponseEntity handleSignInException(SignInCredentialsException e) {
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
     }

    @ExceptionHandler(CreateUserException.class)
    public ResponseEntity handleCreateUserException(CreateUserException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
