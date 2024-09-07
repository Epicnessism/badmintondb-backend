package com.wangindustries.badmintondbbackend.models.requests;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.wangindustries.badmintondbbackend.models.RacketDetails;

import java.util.UUID;

@JsonAutoDetect
public record CreateStringingRequest(UUID stringerId, RacketDetails racketToString, boolean isNewRacket, String method,
                                     double price, int mains, int crosses,
//                                     UUID stringEntityMains,
//                                     UUID stringEntityCrosses,
                                     int mainsInMeters, int crossesInMeters) {
}
