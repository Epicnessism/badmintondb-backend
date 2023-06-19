package com.wangindustries.badmintondbbackend.controllers;

import com.wangindustries.badmintondbbackend.entities.User;
import com.wangindustries.badmintondbbackend.models.BaseUserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UsersController {

    @GetMapping("/users")
    public ResponseEntity<BaseUserResponse> getUser(@RequestParam(value = "name") String userInputName) {
        System.out.println("Test Get User");
        UUID testUUID = UUID.randomUUID();
        return new ResponseEntity<>(new BaseUserResponse(userInputName, "Test Family Name", testUUID), HttpStatus.OK);
    }

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseUserResponse> createUser(@RequestBody User user) { //Todo create a requestBody model for this endpoint, DO NOT USE DB ENTITY
        System.out.println("Test Post endpoint");
        UUID testUUID = UUID.randomUUID();
        return new ResponseEntity<>(new BaseUserResponse("Test Given Name", "Test Family Name 2", testUUID), HttpStatus.CREATED);
    }

}
