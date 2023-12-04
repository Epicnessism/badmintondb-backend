package com.wangindustries.badmintondbbackend.utils;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder {

    private static final Logger logger = LoggerFactory.getLogger(PasswordEncoder.class);
    public String encryptPassword(final String passwordInput) {
        return BCrypt.withDefaults().hashToString(12, passwordInput.toCharArray());
    }

    public boolean verifyPassword(final String passwordInput, final String passwordExpected) {
        String encryptedPwd = encryptPassword(passwordInput);
        logger.info("Input: {}, Expected: {}, Input after encrpyting: {}", passwordInput, passwordExpected, encryptedPwd);
        return BCrypt.verifyer().verify(passwordInput.toCharArray(), passwordExpected.getBytes()).verified;
    }
}
