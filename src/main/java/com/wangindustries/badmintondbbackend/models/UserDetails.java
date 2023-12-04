package com.wangindustries.badmintondbbackend.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class UserDetails { //todo implement and replace/extend as needed
    private final UUID userId;
    private final String givenName;
    private final String familyName;
}
