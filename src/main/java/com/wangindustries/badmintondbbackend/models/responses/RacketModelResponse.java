package com.wangindustries.badmintondbbackend.models.responses;

import java.util.UUID;

public record RacketModelResponse(UUID racketId, String make, String model) {}
