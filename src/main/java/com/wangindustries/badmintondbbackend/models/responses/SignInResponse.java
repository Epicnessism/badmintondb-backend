package com.wangindustries.badmintondbbackend.models.responses;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
@JsonSerialize
public class SignInResponse {
    private UUID userId;
}
