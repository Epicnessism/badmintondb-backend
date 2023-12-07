package com.wangindustries.badmintondbbackend.services;

import com.wangindustries.badmintondbbackend.entities.Racket;
import com.wangindustries.badmintondbbackend.entities.Stringing;
import com.wangindustries.badmintondbbackend.entities.User;
import com.wangindustries.badmintondbbackend.models.CreateStringingRequest;
import com.wangindustries.badmintondbbackend.models.StringingMethod;
import com.wangindustries.badmintondbbackend.repositories.RacketRepository;
import com.wangindustries.badmintondbbackend.repositories.StringingRepository;
import com.wangindustries.badmintondbbackend.repositories.UsersRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Component
@Transactional
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
        User requesterUser = usersRepository.findByUserId(createStringingRequest.getRacketToString().getOwnerUserId()); //todo implement requesterUserId in create payload later

        Racket racketToBeStrung = null; //what to do about this if null?
        if(createStringingRequest.isNewRacket()) {
            //create a new Racket entity
            Racket newRacket = new Racket(UUID.randomUUID(), createStringingRequest.getRacketToString().getMake(), createStringingRequest.getRacketToString().getModel(), requesterUser);
            racketToBeStrung = racketRepository.save(newRacket);
        } else {
            //otherwise attempt to get the existing racket
            racketRepository.getByRacketId(createStringingRequest.getRacketToString().getRacketId());
        }


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

//    private Racket findOrCreateRacketById(final CreateStringingRequest createStringingRequest) {
//        Racket foundRacket = racketRepository.getByRacketId(createStringingRequest.getRacketId());
//        if(foundRacket != null) {
//            return foundRacket;
//        } else {
//            Racket newRacket = new Racket(
//                    createStringingRequest.getRacketId(),
//            );
//            racketRepository.save()
//        }
//
//    }
}
