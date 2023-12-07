package com.wangindustries.badmintondbbackend.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class RacketDetails {
    private final UUID racketId;
    private final String make;
    private final String model;
    private final UUID ownerUserId;
}
