package com.wangindustries.badmintondbbackend.services;

import com.wangindustries.badmintondbbackend.Converters.UserDetailsConverter;
import com.wangindustries.badmintondbbackend.models.UserDetails;
import com.wangindustries.badmintondbbackend.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    public List<UserDetails> getAllStringers() {
        return usersRepository.findByIsStringerTrue().stream().map(UserDetailsConverter::convertToRacketDetails).toList();
    }
}
