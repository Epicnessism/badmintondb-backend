package com.wangindustries.badmintondbbackend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum StringingMethod {
    TWOKNOT("2 Knot"),
    FOURKNOT("4 Knot"),
    OTHER("Other");

    @Getter public final String methodName;

}
