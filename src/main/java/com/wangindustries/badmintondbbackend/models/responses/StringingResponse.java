package com.wangindustries.badmintondbbackend.models.responses;

import com.wangindustries.badmintondbbackend.models.RacketDetails;
import com.wangindustries.badmintondbbackend.models.StringerUser;
import com.wangindustries.badmintondbbackend.models.enums.StringingStatus;
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
    private final boolean isCompleted;
    private final StringingStatus status;
    private final String notes;
    private final double price;
//    private final StringDetails stringMains;
//    private final StringDetails stringCrosses;
}
