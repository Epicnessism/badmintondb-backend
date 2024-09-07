package com.wangindustries.badmintondbbackend.models.responses;

import java.util.List;

public record ListStringingsResponse(Integer count, List<StringingResponse> stringingResponseList) {}
