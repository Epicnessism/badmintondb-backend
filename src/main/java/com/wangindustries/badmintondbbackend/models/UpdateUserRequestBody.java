package com.wangindustries.badmintondbbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wangindustries.badmintondbbackend.models.enums.Gender;
import lombok.Data;

import java.util.Date;

@Data
public class UpdateUserRequestBody {
//    private String username; //todo disabled for now
//    private String password; //todo disabled for now
//    private String email; //todo disabled for now
    private String givenName;
    private String familyName;
    private Date dateOfBirth;
    private Gender gender;
    private Boolean isStringer;
}
