package com.wangindustries.badmintondbbackend.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonSerialize
public class SignInResponse {
    private String testForNow;
}
