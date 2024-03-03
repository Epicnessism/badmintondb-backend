package com.wangindustries.badmintondbbackend.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ListStringingsResponse {
    private final Integer count;
    private final List<StringingResponse> stringingResponseList;
}
