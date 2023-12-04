package com.wangindustries.badmintondbbackend.Converters;

import com.wangindustries.badmintondbbackend.entities.Racket;
import com.wangindustries.badmintondbbackend.entities.Stringing;
import com.wangindustries.badmintondbbackend.entities.User;
import com.wangindustries.badmintondbbackend.models.RacketDetails;
import com.wangindustries.badmintondbbackend.models.StringerUser;
import com.wangindustries.badmintondbbackend.models.StringingResponse;

public class StringingResponseConverter {


    public static StringingResponse convertToStringingResponse(final Stringing stringing) {
        User stringingUser = stringing.getStringerUser();
        StringerUser stringerUser = new StringerUser(stringingUser.getUserId(), stringingUser.getGivenName(), stringingUser.getFamilyName());
        Racket racket = stringing.getRacket();
        RacketDetails racketDetails = new RacketDetails(racket.getRacketId(), racket.getMake(), racket.getModel(), racket.getOwner().getUserId());

        return new StringingResponse(
                stringing.getStringingId(),
                stringerUser,
                racketDetails,
                stringing.getRequestedTimestamp(),
                stringing.getCompletedTimestamp(),
                stringing.getLastUpdatedTimestamp(),
                stringing.getNotes()
        );
    }
}
