package com.wangindustries.badmintondbbackend.models.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.jackson.JsonComponent;

import java.util.UUID;


@Data
@JsonComponent
@NoArgsConstructor
@AllArgsConstructor
public class BaseUserResponse {

    private String givenName;
    private String familyName;
    private UUID userId;

}
