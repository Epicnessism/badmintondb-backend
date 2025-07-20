package com.wangindustries.badmintondbbackend.models.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RacketModelsResponse {
    private final List<RacketModelResponse> racketModels;
}