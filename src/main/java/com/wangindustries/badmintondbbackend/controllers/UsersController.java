package com.wangindustries.badmintondbbackend.controllers;

import com.wangindustries.badmintondbbackend.Converters.StringingResponseConverter;
import com.wangindustries.badmintondbbackend.Entities.Stringing;
import com.wangindustries.badmintondbbackend.models.AggregateStringingDataByStringerUserId;
import com.wangindustries.badmintondbbackend.models.ListStringingsResponse;
import com.wangindustries.badmintondbbackend.models.RacketDetails;
import com.wangindustries.badmintondbbackend.models.StringingResponse;
import com.wangindustries.badmintondbbackend.models.UserDetails;
import com.wangindustries.badmintondbbackend.services.RacketService;
import com.wangindustries.badmintondbbackend.services.StringingService;
import com.wangindustries.badmintondbbackend.services.UsersService;
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

    @Autowired
    UsersService usersService;

    @Autowired
    RacketService racketService;

    @GetMapping("/user/stringers")
    public ResponseEntity<List<UserDetails>> getStringers() {
        return new ResponseEntity<>(usersService.getAllStringers(), HttpStatus.OK);
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
            if(stringerOnly != null && stringerOnly) {
                listOfStringings = stringingService.getAllStringingByRequesterUserId(userId, completedOnly);
            } else if(ownerOnly != null && ownerOnly) {
                listOfStringings = stringingService.getAllStringingByStringerUserId(userId, completedOnly);
            } else {
                listOfStringings = stringingService.getAllStringingByUserIdOrRequesterUserId(userId, completedOnly);
            }
        } else {
            if(stringerOnly != null && stringerOnly) {
                listOfStringings = stringingService.getAllStringingByStringerUserId(userId);
            } else if(ownerOnly != null && ownerOnly) {
                listOfStringings = stringingService.getAllStringingByRequesterUserId(userId);
            } else {
                listOfStringings = stringingService.getAllStringingByUserIdOrRequesterUserId(userId);
            }
        }

        logger.info(listOfStringings.toString());
        List<StringingResponse> stringingResponses = listOfStringings.stream().map(StringingResponseConverter::convertToStringingResponse).toList();
        return new ResponseEntity<>(new ListStringingsResponse(stringingResponses.size(), stringingResponses), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/analytical/aggregate")
    public ResponseEntity<List<AggregateStringingDataByStringerUserId>> getAggregateStringingDataForAnUser(@PathVariable(value = "userId") UUID userId) { //todo implement stringerUser vs requesterUser, etc, etc
        return new ResponseEntity<>(stringingService.getAggregateStringingDataByStringerUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/racket/all")
    public ResponseEntity<List<RacketDetails>> getAllRacketsForAnUser(@PathVariable(value = "userId") UUID userId) {
        return new ResponseEntity<>(racketService.getAllRacketsByOwnerId(userId), HttpStatus.OK);
    }
}
