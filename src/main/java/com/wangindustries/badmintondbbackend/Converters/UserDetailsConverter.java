package com.wangindustries.badmintondbbackend.Converters;

import com.wangindustries.badmintondbbackend.Entities.Racket;
import com.wangindustries.badmintondbbackend.Entities.User;
import com.wangindustries.badmintondbbackend.models.RacketDetails;
import com.wangindustries.badmintondbbackend.models.UserDetails;

public class UserDetailsConverter {

    public static UserDetails convertToRacketDetails(final User user) {
    return new UserDetails(user.getUserId(), user.getGivenName(), user.getFamilyName());
    }
}
