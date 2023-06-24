package com.wangindustries.badmintondbbackend.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
@JsonSerialize
public class SignInResponse {
    private String testForNow;
}
