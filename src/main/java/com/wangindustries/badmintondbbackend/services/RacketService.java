package com.wangindustries.badmintondbbackend.services;

import com.wangindustries.badmintondbbackend.models.RacketDetails;
import com.wangindustries.badmintondbbackend.repositories.RacketRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Transactional
public class RacketService {


    @Autowired
    RacketRepository racketRepository;

    private static final Logger logger = LoggerFactory.getLogger(RacketService.class);

    public List<RacketDetails> getAllRacketsByOwnerId(final UUID ownerUserId) {
        return racketRepository.getAllRacketsByOwnerUserId(ownerUserId).stream().map(RacketConverter::convertToRacketDetails).toList();
    }
}
