package com.wangindustries.badmintondbbackend.services;

import com.wangindustries.badmintondbbackend.Converters.UserDetailsConverter;
import com.wangindustries.badmintondbbackend.Entities.User;

import com.wangindustries.badmintondbbackend.models.UserDetails;
import com.wangindustries.badmintondbbackend.repositories.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class UsersService {

    private static final Logger logger = LoggerFactory.getLogger(UsersService.class);

    @Autowired
    UsersRepository usersRepository;

    public List<UserDetails> getAllStringers() {
        return usersRepository.findByIsStringerTrue().stream().map(UserDetailsConverter::convertToRacketDetails).toList();
    }

    public User findByUserId(UUID userId) {
        return usersRepository.findByUserId(userId);
    }

    public void updateAllowedUserFields(UUID userId, UpdateUserRequestBody updateUserRequestBody) {
        User updatedUser = usersRepository.findByUserId(userId);

        updatedUser.setFamilyName(Optional.ofNullable(updateUserRequestBody.getFamilyName()).isPresent() ? updateUserRequestBody.getFamilyName() : updatedUser.getFamilyName());
        updatedUser.setGivenName(Optional.ofNullable(updateUserRequestBody.getGivenName()).isPresent() ? updateUserRequestBody.getGivenName() : updatedUser.getGivenName());
        updatedUser.setGender(Optional.ofNullable(updateUserRequestBody.getGender()).isPresent() ? updateUserRequestBody.getGender() : updatedUser.getGender());
        updatedUser.setStringer(Optional.ofNullable(updateUserRequestBody.getIsStringer()).isPresent() ? updateUserRequestBody.getIsStringer() : updatedUser.isStringer());
        updatedUser.setDateOfBirth(Optional.ofNullable(updateUserRequestBody.getDateOfBirth()).isPresent() ? updateUserRequestBody.getDateOfBirth() : updatedUser.getDateOfBirth());

        logger.info(String.valueOf(updatedUser));

        usersRepository.save(updatedUser);
    }
}
