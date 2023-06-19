package com.wangindustries.badmintondbbackend.models;

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
}
