package com.wangindustries.badmintondbbackend.controllers;

import com.wangindustries.badmintondbbackend.Entities.RacketModel;
import com.wangindustries.badmintondbbackend.Entities.Stringing;
import com.wangindustries.badmintondbbackend.models.requests.CreateStringingRequest;
import com.wangindustries.badmintondbbackend.models.requests.PatchStringingRequestBody;
import com.wangindustries.badmintondbbackend.models.responses.RacketModelResponse;
import com.wangindustries.badmintondbbackend.models.responses.StringingResponse;
import com.wangindustries.badmintondbbackend.services.StringingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static com.wangindustries.badmintondbbackend.Converters.RacketConverter.convertToRacketModelResponse;
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

    @CrossOrigin
    @PostMapping(value = "stringing", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StringingResponse> createStringingSession(@RequestBody CreateStringingRequest createStringingRequest) {
        logger.info("Stringing Request: {}", createStringingRequest);
        Stringing insertedStringing = stringingService.createStringingSession(createStringingRequest);
        return new ResponseEntity<StringingResponse>(convertToStringingResponse(insertedStringing),HttpStatus.CREATED);
    }

    @PatchMapping(value = "stringing/{stringingId}")
    public ResponseEntity<StringingResponse> patchStringingById(@PathVariable UUID stringingId, @RequestBody PatchStringingRequestBody patchStringingRequestBody) {
        Stringing patchedStringing = stringingService.patchStringingSessionById(stringingId, patchStringingRequestBody);
        return new ResponseEntity<StringingResponse>(convertToStringingResponse(patchedStringing), HttpStatus.OK);
    }

    @GetMapping(value = "info/racketModels")
    public ResponseEntity<List<RacketModelResponse>> getRacketModels() {
        List<RacketModel> rackets = stringingService.getAllRacketModels();
        return new ResponseEntity<List<RacketModelResponse>>(convertToRacketModelResponse(rackets), HttpStatus.OK);
    }
}
