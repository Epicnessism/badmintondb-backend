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
    private final RacketDetails racketToString;
    private final boolean isNewRacket;
    private final String method;
    private final double price;
    private final int mains;
    private final int crosses;
    private final UUID stringEntityMains;
    private final UUID stringEntityCrosses;
    private final int mainsInMeters;
    private final int crossesInMeters;
}
