package com.wangindustries.badmintondbbackend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StringingMethod {
    TWOKNOT("2 Knot"),
    FOURKNOT("4 Knot"),
    OTHER("Other");

    public final String methodName;

}
