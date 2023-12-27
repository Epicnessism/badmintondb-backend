package com.wangindustries.badmintondbbackend.repositories;

import com.wangindustries.badmintondbbackend.Entities.Racket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface RacketRepository extends CrudRepository<Racket, UUID> {

    Racket getByRacketId(@Param("racketId") UUID racketId);
}
