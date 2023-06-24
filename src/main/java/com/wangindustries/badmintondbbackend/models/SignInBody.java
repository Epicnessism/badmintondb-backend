package com.wangindustries.badmintondbbackend.models;

import lombok.Data;

@Data
public class SignInBody {

    private String username;
    private String password;
}
