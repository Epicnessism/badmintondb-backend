package com.wangindustries.badmintondbbackend.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
//public class StringerUser extends UserDetails { //todo figure out how to make this work
public class StringerUser {
    private final UUID userId;
    private final String givenName;
    private final String familyName;
}
