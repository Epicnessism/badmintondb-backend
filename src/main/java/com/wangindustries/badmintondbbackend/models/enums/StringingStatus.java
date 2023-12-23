package com.wangindustries.badmintondbbackend.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StringingStatus {
    PENDING("Pending","Pending something?"),
    REJECTED("Rejected","Rejected by stringer"),
    DELIVERED("Delivered","Delivered to the stringer"),
    IN_PROGRESS("In Progress", "In some state of progress"),
    CANCELED("Canceled", "Canceled, will not be completed"),
    FAILED("Failed", "Failed, for some reason"),
    COMPLETED("Completed", "Stringing completed, ready for pickup")
    ;

    public final String statusName;
    public final String statusDescription;
}
