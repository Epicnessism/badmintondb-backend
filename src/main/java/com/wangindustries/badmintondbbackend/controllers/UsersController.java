package com.wangindustries.badmintondbbackend.controllers;

import com.wangindustries.badmintondbbackend.models.BaseUserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UsersController {

    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

    @GetMapping("/users")
    public ResponseEntity<BaseUserResponse> getUser(@RequestParam(value = "name") String userInputName) {
        logger.info("Testing logging of getUser endpoint");
        UUID testUUID = UUID.randomUUID();
        return new ResponseEntity<>(new BaseUserResponse(userInputName, "Test Family Name", testUUID), HttpStatus.OK);
    }
}
