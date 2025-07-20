package com.wangindustries.badmintondbbackend.Converters;

import com.wangindustries.badmintondbbackend.Entities.Racket;
import com.wangindustries.badmintondbbackend.Entities.StringEntity;
import com.wangindustries.badmintondbbackend.Entities.Stringing;
import com.wangindustries.badmintondbbackend.Entities.User;
import com.wangindustries.badmintondbbackend.models.RacketDetails;
import com.wangindustries.badmintondbbackend.models.StringDetails;
import com.wangindustries.badmintondbbackend.models.StringerUser;
import com.wangindustries.badmintondbbackend.models.responses.StringingResponse;
import com.wangindustries.badmintondbbackend.models.UserDetails;

public class StringingResponseConverter {


    public static StringingResponse convertToStringingResponse(final Stringing stringing) {
        User stringingUser = stringing.getStringer();
        StringerUser stringerUser = new StringerUser(stringingUser.getUserId(), stringingUser.getGivenName(), stringingUser.getFamilyName());

        Racket racket = stringing.getRacket();
        UserDetails ownerUser = new UserDetails(racket.getRacketId(), stringing.getRequester().getGivenName(), stringing.getRequester().getFamilyName());
        RacketDetails racketDetails = new RacketDetails(racket.getRacketId(), racket.getMake(), racket.getModel(), ownerUser);

//        StringEntity mainString = stringing.getStringMains();
//        StringDetails mainStringDetails = new StringDetails(mainString.getId(), mainString.getModel(), mainString.getMake(), mainString.getColor());
//        StringEntity crossString = stringing.getStringCrosses();
//        StringDetails crpssStringDetails = new StringDetails(crossString.getId(), crossString.getModel(), crossString.getMake(), crossString.getColor());
        //todo add stringingStatus and StringType, etc, etc

        return new StringingResponse(
                stringing.getStringingId(),
                stringerUser,
                racketDetails,
                stringing.getRequestedTimestamp(),
                stringing.getCompletedTimestamp(),
                stringing.getLastUpdatedTimestamp(),
                stringing.isCompleted(),
                stringing.getStatus(),
                stringing.getNotes(),
                stringing.getPrice()
//                mainStringDetails,
//                crpssStringDetails
        );
    }
}
