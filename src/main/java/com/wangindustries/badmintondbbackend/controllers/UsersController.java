package com.wangindustries.badmintondbbackend.controllers;

import com.wangindustries.badmintondbbackend.entities.User;
import com.wangindustries.badmintondbbackend.models.BaseUserResponse;
import com.wangindustries.badmintondbbackend.models.CreateUserRequestBody;
import java.util.UUID;

import com.wangindustries.badmintondbbackend.repositories.UsersRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    UsersRepository usersRepository;

    ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/users")
    public ResponseEntity<BaseUserResponse> getUser(@RequestParam(value = "name") String userInputName) {
        logger.info("Testing logging of getUser endpoint");
        UUID testUUID = UUID.randomUUID();
        return new ResponseEntity<>(new BaseUserResponse(userInputName, "Test Family Name", testUUID), HttpStatus.OK);
    }

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseUserResponse> createUser(@RequestBody CreateUserRequestBody createUserRequestBody) {
        logger.info("Testing logging of createUsers endpoint: {}", createUserRequestBody);
        //todo validate request body
        User newUser = modelMapper.map(createUserRequestBody, User.class);
        logger.info("Testing modelMapper for newUser default mapping::{}", newUser);
        usersRepository.save(newUser); //todo use modelMapper here, need to add dependency and create converters...?
        UUID testUUID = UUID.randomUUID();
        return new ResponseEntity<>(new BaseUserResponse("Test Given Name", "Test Family Name 2", testUUID), HttpStatus.CREATED);
    }

}
