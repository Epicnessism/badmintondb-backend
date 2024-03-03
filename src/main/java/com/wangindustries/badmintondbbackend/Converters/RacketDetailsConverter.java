package com.wangindustries.badmintondbbackend.Converters;

import com.wangindustries.badmintondbbackend.Entities.Racket;
import com.wangindustries.badmintondbbackend.models.RacketDetails;
import com.wangindustries.badmintondbbackend.models.UserDetails;

public class RacketDetailsConverter {

    public static RacketDetails convertToRacketDetails(final Racket racket) {
        UserDetails ownerUser = new UserDetails(racket.getRacketId(), racket.getOwner().getGivenName(),  racket.getOwner().getFamilyName());
        return new RacketDetails(racket.getRacketId(), racket.getMake() ,racket.getModel(), ownerUser);
    }
}
