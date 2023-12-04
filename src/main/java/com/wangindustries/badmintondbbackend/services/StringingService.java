package com.wangindustries.badmintondbbackend.services;

import com.wangindustries.badmintondbbackend.entities.Racket;
import com.wangindustries.badmintondbbackend.entities.Stringing;
import com.wangindustries.badmintondbbackend.entities.User;
import com.wangindustries.badmintondbbackend.models.CreateStringingRequest;
import com.wangindustries.badmintondbbackend.models.StringingMethod;
import com.wangindustries.badmintondbbackend.repositories.RacketRepository;
import com.wangindustries.badmintondbbackend.repositories.StringingRepository;
import com.wangindustries.badmintondbbackend.repositories.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Component
public class StringingService {

    @Autowired
    StringingRepository stringingRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    RacketRepository racketRepository;

    private static final Logger logger = LoggerFactory.getLogger(StringingService.class);

    public Stringing getStringingById(final UUID stringingId) {
        return stringingRepository.getByStringingId(stringingId);
    }

    public Stringing createStringingSession(final CreateStringingRequest createStringingRequest) {
        User stringerUser = usersRepository.findByUserId(createStringingRequest.getStringerId());
        User requesterUser = usersRepository.findByUserId(createStringingRequest.getOwnerId()); //todo implement requesterUserId in create payload later
        Racket racketToBeStrung = racketRepository.getByRacketId(createStringingRequest.getRacketId());
        Stringing stringingToSave = new Stringing(
                UUID.randomUUID(),
                stringerUser,
                racketToBeStrung,
                Timestamp.from(Instant.now()),
                null,
                null,
                createStringingRequest.getStringName(),
                createStringingRequest.getMains(),
                createStringingRequest.getMainsInMeters(),
                createStringingRequest.getCrosses(),
                createStringingRequest.getCrossesInMeters(),
                StringingMethod.valueOf(createStringingRequest.getMethod()),
                false,
                "Notes to be implemented later",
                requesterUser
        );
        Stringing insertedStringing = stringingRepository.save(stringingToSave);
        logger.info("Inserted: {}", insertedStringing);
        return insertedStringing;
    }
}
