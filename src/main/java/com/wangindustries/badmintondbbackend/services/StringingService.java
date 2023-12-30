package com.wangindustries.badmintondbbackend.services;

import com.wangindustries.badmintondbbackend.Entities.StringEntity;
import com.wangindustries.badmintondbbackend.Mappers.StringingMapper;
import com.wangindustries.badmintondbbackend.Entities.Racket;
import com.wangindustries.badmintondbbackend.Entities.Stringing;
import com.wangindustries.badmintondbbackend.Entities.User;
import com.wangindustries.badmintondbbackend.models.AggregateStringingDataByStringerUserId;
import com.wangindustries.badmintondbbackend.models.CreateStringingRequest;
import com.wangindustries.badmintondbbackend.models.PatchStringingRequestBody;
import com.wangindustries.badmintondbbackend.models.enums.StringingMethod;
import com.wangindustries.badmintondbbackend.models.enums.StringingStatus;
import com.wangindustries.badmintondbbackend.repositories.RacketRepository;
import com.wangindustries.badmintondbbackend.repositories.StringEntityRepository;
import com.wangindustries.badmintondbbackend.repositories.StringingRepository;
import com.wangindustries.badmintondbbackend.repositories.UsersRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
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

    @Autowired
    StringEntityRepository stringEntityRepository;

    @Autowired
    StringingMapper stringingMapper;

    private static final Logger logger = LoggerFactory.getLogger(StringingService.class);

    public List<Stringing> getAllStringingByStringerUserId(final UUID userId) {
        return stringingRepository.findByStringerUserId(userId);
    };

    public List<Stringing> getAllStringingByStringerUserId(final UUID userId, final boolean isCompleted) {
        return stringingRepository.findByStringerUserIdAndIsCompleted(userId, isCompleted);
    };


    public List<Stringing> getAllStringingByRequesterUserId(final UUID userId) {
        return stringingRepository.findByRequesterUserId(userId);
    }

    public List<Stringing> getAllStringingByRequesterUserId(final UUID userId, final boolean isCompleted) {
        return stringingRepository.findByRequesterUserIdAndIsCompleted(userId, isCompleted);
    }


    public List<Stringing> getAllStringingByUserIdOrRequesterUserId(final UUID userId) {
        return stringingRepository.findByStringerUserIdOrRequesterUserId(userId, userId);
    }

    public List<Stringing> getAllStringingByUserIdOrRequesterUserId(final UUID userId, final boolean isCompleted) {
        return stringingRepository.findByStringerUserIdOrRequesterUserIdAndIsCompleted(userId, userId, isCompleted);
    };


    public Stringing getStringingById(final UUID stringingId) {
        return stringingRepository.getByStringingId(stringingId);
    }

    public Stringing patchStringingSessionById(final UUID stringingId, final PatchStringingRequestBody patchStringingRequestBody) {
        Stringing foundStringing = stringingRepository.getByStringingId(stringingId);
        stringingMapper.updateStringingFromPatchStringingRequestBody(patchStringingRequestBody, foundStringing);
        return stringingRepository.save(foundStringing);
    }


    public Stringing createStringingSession(final CreateStringingRequest createStringingRequest) {
        User stringerUser = usersRepository.findByUserId(createStringingRequest.getStringerId());
        User requesterUser = usersRepository.findByUserId(createStringingRequest.getRacketToString().getOwnerUserId()); //todo implement requesterUserId in create payload later
        Racket racketToBeStrung; //what to do about this if null?
        StringEntity stringEntityMains = stringEntityRepository.findById(createStringingRequest.getStringEntityMains()).orElseThrow(); //todo what if desn't exist yet? currently just throw
        StringEntity stringEntityCrosses = createStringingRequest.getStringEntityMains() == createStringingRequest.getStringEntityCrosses() ? stringEntityMains : stringEntityRepository.findById(createStringingRequest.getStringEntityCrosses()).orElseThrow();


        if(createStringingRequest.isNewRacket()) {
            //create a new Racket entity
            Racket newRacket = new Racket(UUID.randomUUID(), createStringingRequest.getRacketToString().getMake(), createStringingRequest.getRacketToString().getModel(), requesterUser);
            racketToBeStrung = racketRepository.save(newRacket);
        } else {
            //otherwise attempt to get the existing racket
            racketToBeStrung = racketRepository.getByRacketId(createStringingRequest.getRacketToString().getRacketId());
        }

        Timestamp currentTimestamp = Timestamp.from(Instant.now());

        Stringing stringingToSave = new Stringing(
                UUID.randomUUID(),
                currentTimestamp,
                null,
                currentTimestamp,
                createStringingRequest.getMains(),
                createStringingRequest.getMainsInMeters(),
                createStringingRequest.getCrosses(),
                createStringingRequest.getCrossesInMeters(),
                StringingMethod.valueOf(createStringingRequest.getMethod()),
                StringingStatus.CREATED,
                false,
                createStringingRequest.getPrice(),
                "Notes to be implemented later",
                stringEntityMains,
                stringEntityCrosses,
                racketToBeStrung,
                stringerUser,
                requesterUser
        );
        Stringing insertedStringing = stringingRepository.save(stringingToSave);
        logger.info("Inserted: {}", insertedStringing);
        return insertedStringing;
    }

    public List<AggregateStringingDataByStringerUserId> getAggregateStringingDataByStringerUserId(final UUID stringerUserId) {
        return stringingRepository.getAggregateDataByStringerUserId(stringerUserId);
    }
}
