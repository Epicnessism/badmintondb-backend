package com.wangindustries.badmintondbbackend.models.requests;

import com.wangindustries.badmintondbbackend.models.enums.Gender;
import lombok.Data;

import java.util.Date;

@Data
public class CreateUserRequestBody {

    private String username;
    private String password;
    private String email;
    private String givenName;
    private String familyName;
    private Date dateOfBirth;
    private Gender gender;
    private Boolean isStringer; //should be optional/default to false?
}
