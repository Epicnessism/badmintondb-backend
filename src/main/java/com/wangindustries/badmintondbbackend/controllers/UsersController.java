package com.wangindustries.badmintondbbackend.controllers;

import com.wangindustries.badmintondbbackend.Converters.StringingResponseConverter;
import com.wangindustries.badmintondbbackend.Entities.Stringing;
import com.wangindustries.badmintondbbackend.models.BaseUserResponse;
import com.wangindustries.badmintondbbackend.models.ListStringingsResponse;
import com.wangindustries.badmintondbbackend.models.StringingResponse;
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
    public ResponseEntity<ListStringingsResponse> getStringingsForUser(
            @PathVariable(value = "userId") UUID userId,
            @RequestParam(value = "completedOnly", required = false) Boolean completedOnly, //todo completed only with StringingStatus
            @RequestParam(value = "stringerOnly", required = false) Boolean stringerOnly,
            @RequestParam(value = "ownerOnly", required = false) Boolean ownerOnly
    ) {
        logger.info("Got UserId: {} and completedOnly as: {}", userId, completedOnly);

        List<Stringing> listOfStringings;


        if(completedOnly != null) {
            if(stringerOnly != null) {
                listOfStringings = stringingService.getAllStringingByRequesterUserId(userId, completedOnly);
            } else if(ownerOnly != null) {
                listOfStringings = stringingService.getAllStringingByRequesterUserId(userId, completedOnly);
            } else {
                listOfStringings = stringingService.getAllStringingByUserIdOrRequesterUserId(userId, completedOnly);
            }
        } else {
            if(stringerOnly != null) {
                listOfStringings = stringingService.getAllStringingByRequesterUserId(userId);
            } else if(ownerOnly != null) {
                listOfStringings = stringingService.getAllStringingByRequesterUserId(userId);
            } else {
                listOfStringings = stringingService.getAllStringingByUserIdOrRequesterUserId(userId);
            }
        }

        logger.info(listOfStringings.toString());
        List<StringingResponse> stringingResponses = listOfStringings.stream().map(StringingResponseConverter::convertToStringingResponse).toList();
        return new ResponseEntity<>(new ListStringingsResponse(stringingResponses), HttpStatus.OK);
    }
}
