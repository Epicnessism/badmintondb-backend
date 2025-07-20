package com.wangindustries.badmintondbbackend.models.requests;

import lombok.Data;

@Data
public class SignInBody {

    private String username;
    private String password;
}
