package com.wangindustries.badmintondbbackend.controllers;

import com.wangindustries.badmintondbbackend.models.BaseUserResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UsersController {

    @GetMapping("/users")
    public BaseUserResponse getUser(@RequestParam(value = "name") String userInputName) {
        System.out.println("Test Get User");
        UUID testUUID = UUID.randomUUID();
        return new BaseUserResponse(userInputName, "Test Family Name", testUUID);
    }
}
