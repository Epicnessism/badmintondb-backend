package com.wangindustries.badmintondbbackend.models;

import com.wangindustries.badmintondbbackend.models.enums.StringColor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class StringDetails {
    private final UUID id;
    private final String model;
    private final String make;
    private final StringColor color;
}
