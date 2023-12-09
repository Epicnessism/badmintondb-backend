package com.wangindustries.badmintondbbackend.controllers;

import com.wangindustries.badmintondbbackend.entities.Stringing;
import com.wangindustries.badmintondbbackend.models.BaseUserResponse;
import com.wangindustries.badmintondbbackend.services.StringingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class UsersController {
    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    StringingService stringingService;

    @GetMapping("/users")
    public ResponseEntity<BaseUserResponse> getUser(@RequestParam(value = "name") String userInputName) {
        logger.info("Testing logging of getUser endpoint");
        UUID testUUID = UUID.randomUUID();
        return new ResponseEntity<>(new BaseUserResponse(userInputName, "Test Family Name", testUUID), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/stringings")
    public ResponseEntity<Object> getStringingsForUser(@PathVariable(value = "userId") UUID userId, @RequestParam(value = "completedOnly") boolean completedOnly) {
        logger.info("Got UserId: {} and completedOnly as: {}", userId, completedOnly);
        List<Stringing> listOfStringings = stringingService.getAllStringingByUserId(userId);
        logger.info(listOfStringings.toString());
        return null;
    }
}
