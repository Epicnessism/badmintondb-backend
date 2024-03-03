package com.wangindustries.badmintondbbackend.controllers;

import com.wangindustries.badmintondbbackend.Exceptions.CreateUserException;
import com.wangindustries.badmintondbbackend.Exceptions.SignInCredentialsException;
import com.wangindustries.badmintondbbackend.models.BaseUserResponse;
import com.wangindustries.badmintondbbackend.models.CreateUserRequestBody;
import com.wangindustries.badmintondbbackend.models.SignInBody;
import com.wangindustries.badmintondbbackend.models.SignInResponse;
import com.wangindustries.badmintondbbackend.services.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class AuthController {


    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    AuthService authService;

    @PostMapping(value = "auth/signup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseUserResponse> createUser(@RequestBody CreateUserRequestBody createUserRequestBody) {

        logger.info("Testing logging of createUsers endpoint: {}", createUserRequestBody);

        try {
            authService.validateAndCreateNewUser(createUserRequestBody);
        } catch(CreateUserException e) {
            logger.error(e.getMessage());
            throw e;
        }

        UUID testUUID = UUID.randomUUID(); //todo fix this
        return new ResponseEntity<>(new BaseUserResponse("Test Given Name", "Test Family Name 2", testUUID), HttpStatus.CREATED);
    }


    @PostMapping("auth/signin")
    public ResponseEntity<SignInResponse> signInUser(@RequestBody SignInBody signInBody) {
        logger.info("Testing logging of signInUser endpoint: {}", signInBody );
        if (!authService.validateLogin(signInBody.getUsername(), signInBody.getPassword())) {
            throw new SignInCredentialsException("Invalid Credentials");
        }

        //todo should probably return a jwt token or something here to store for future accesses?
        //todo may need to read up on best practices to implement this
        return new ResponseEntity<SignInResponse>(new SignInResponse("Tony Wang Test1"), HttpStatus.ACCEPTED);
    }
}
