package com.wangindustries.badmintondbbackend.models.requests;

import com.wangindustries.badmintondbbackend.models.enums.StringingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatchStringingRequestBody {
//    private RacketDetails racketToString; //todo future enhancements to allow editing the racketDetails? Maybe in a different endpoint call?
//    private boolean isNewRacket; //not really needed right?
    private UUID stringerId;
    private String method;
    private double price;
    private int mains;
    private int crosses;
    private String stringName;
    private int mainsInMeters;
    private int crossesInMeters;
    private Boolean completed;
    private StringingStatus stringingStatus;
}
