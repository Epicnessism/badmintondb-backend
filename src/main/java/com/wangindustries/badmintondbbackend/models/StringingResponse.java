package com.wangindustries.badmintondbbackend.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
public class StringingResponse {
    private final UUID stringingId;
    private final StringerUser stringingUser;
    private final RacketDetails racketDetails;
    private final Date requestedTimestamp;
    private final Date completedTimestamp;
    private final Date lastUpdatedTimestamp;
    private final String notes;

}
