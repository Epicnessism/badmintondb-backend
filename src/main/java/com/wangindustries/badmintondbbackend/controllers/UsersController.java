package com.wangindustries.badmintondbbackend.controllers;

import com.wangindustries.badmintondbbackend.entities.User;
import com.wangindustries.badmintondbbackend.models.BaseUserResponse;
import com.wangindustries.badmintondbbackend.models.CreateUserRequestBody;
import java.util.UUID;

import com.wangindustries.badmintondbbackend.repositories.UsersRepository;
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

    //todo add logging, log4j? sl4j?

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/users")
    public ResponseEntity<BaseUserResponse> getUser(@RequestParam(value = "name") String userInputName) {
        System.out.println("Test Get User");
        UUID testUUID = UUID.randomUUID();
        return new ResponseEntity<>(new BaseUserResponse(userInputName, "Test Family Name", testUUID), HttpStatus.OK);
    }

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseUserResponse> createUser(@RequestBody CreateUserRequestBody createUserRequestBody) {
        System.out.println("Test Post endpoint");
        usersRepository.save(new User()); //todo use modelMapper here, need to add dependency and create converters...?
        UUID testUUID = UUID.randomUUID();
        return new ResponseEntity<>(new BaseUserResponse("Test Given Name", "Test Family Name 2", testUUID), HttpStatus.CREATED);
    }

}
