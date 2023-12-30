package com.wangindustries.badmintondbbackend.services;

import com.wangindustries.badmintondbbackend.Exceptions.CreateUserException;
import com.wangindustries.badmintondbbackend.Entities.User;
import com.wangindustries.badmintondbbackend.models.CreateUserRequestBody;
import com.wangindustries.badmintondbbackend.repositories.UsersRepository;
import com.wangindustries.badmintondbbackend.utils.PasswordEncoder;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    ModelMapper modelMapper;

    Pattern passwordPattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");

    public boolean validateLogin(final String username, final String password) {
        User foundUser = usersRepository.findByUsername(username);
        if(foundUser == null) {
            return false;
        }
//        Boolean x = passwordEncoder.verifyPassword(password, foundUser.getPassword());
//        logger.info(String.valueOf(x));
        return passwordEncoder.verifyPassword(password, foundUser.getPassword());
    }

    public void validateAndCreateNewUser(final CreateUserRequestBody body) {
        String passwordInput = body.getPassword();
        boolean validPassword = passwordPattern.matcher(passwordInput).matches();
        if(!validPassword) {
            throw new CreateUserException("invalid password");
        }

        String encryptedPassword = passwordEncoder.encryptPassword(passwordInput);

        User newUser = modelMapper.map(body, User.class);
        newUser.setPassword(encryptedPassword);

        usersRepository.save(newUser);
    }

    public String generateJwtToken() {
        return "test";
    }

    public String validateJwtToken() {
        return "test";
    }
}
