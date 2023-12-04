package com.wangindustries.badmintondbbackend.controllers;

import com.wangindustries.badmintondbbackend.entities.Stringing;
import com.wangindustries.badmintondbbackend.models.CreateStringingRequest;
import com.wangindustries.badmintondbbackend.models.StringingResponse;
import com.wangindustries.badmintondbbackend.services.StringingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.wangindustries.badmintondbbackend.Converters.StringingResponseConverter.convertToStringingResponse;

@RestController
public class StringingController {
    private static final Logger logger = LoggerFactory.getLogger(StringingController.class);

    @Autowired
    StringingService stringingService;

    @GetMapping(value = "stringing/{stringingId}")
    public ResponseEntity<StringingResponse> getStringingById(@PathVariable UUID stringingId) {
        logger.info("Stringing ID: {}", stringingId);
        Stringing foundStringing = stringingService.getStringingById(stringingId);
        logger.info("Found Stringing: {}", foundStringing.toString());
        return new ResponseEntity<StringingResponse>(convertToStringingResponse(foundStringing), HttpStatus.OK);
    }

    @PostMapping(value = "stringing", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StringingResponse> createStringingSession(@RequestBody CreateStringingRequest createStringingRequest) {
        logger.info("Stringing Request: {}", createStringingRequest);
        Stringing insertedStringing = stringingService.createStringingSession(createStringingRequest);
//        return new ResponseEntity<>(StringingResponse);
        return null;
    }
}
