package com.wangindustries.badmintondbbackend.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StringColor {

    WHITE("White"),
    BLACK("Black"),
    ORANGE("Orange"),
    BLUE("Blue"),
    DARK_BLUE("Dark Blue");

    public final String colorName;
}
