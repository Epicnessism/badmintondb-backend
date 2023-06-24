package com.wangindustries.badmintondbbackend.utils;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder {
    public String encryptPassword(final String passwordInput) {
        return BCrypt.withDefaults().hashToString(12, passwordInput.toCharArray());
    }

    public boolean verifyPassword(final String passwordInput, final String passwordExpected) {
        return BCrypt.verifyer().verify(BCrypt.withDefaults().hashToChar(12, passwordInput.toCharArray()), passwordExpected).verified;
    }
}
