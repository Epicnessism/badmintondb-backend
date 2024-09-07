package com.wangindustries.badmintondbbackend.Converters;

import com.wangindustries.badmintondbbackend.Entities.Racket;
import com.wangindustries.badmintondbbackend.Entities.RacketModel;
import com.wangindustries.badmintondbbackend.models.RacketDetails;
import com.wangindustries.badmintondbbackend.models.UserDetails;
import com.wangindustries.badmintondbbackend.models.responses.RacketModelResponse;

import java.util.List;

public class RacketConverter {

    public static RacketDetails convertToRacketDetails(final Racket racket) {
        UserDetails ownerUser = new UserDetails(racket.getRacketId(), racket.getOwner().getGivenName(),  racket.getOwner().getFamilyName());
        return new RacketDetails(racket.getRacketId(), racket.getMake() ,racket.getModel(), ownerUser);
    }

    public static List<RacketModelResponse> convertToRacketModelResponse(final List<RacketModel> rackets) {
        return rackets.stream().map(racketModel -> new RacketModelResponse(racketModel.getRacketId(), racketModel.getMake(), racketModel.getModel())).toList();
    }
}
