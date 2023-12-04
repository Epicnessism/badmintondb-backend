package com.wangindustries.badmintondbbackend.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
@JsonAutoDetect
public class CreateStringingRequest {
    private final UUID stringerId;
    private final UUID racketId;
    private final UUID ownerId;
    private final String method;
    private final double price;

    //optional parameters if it's a new racket...
    private final String make;
    private final String model;
    private final int mains;
    private final int crosses;
    private final String stringName;
    private final int mainsInMeters;
    private final int crossesInMeters;
    //...
}
