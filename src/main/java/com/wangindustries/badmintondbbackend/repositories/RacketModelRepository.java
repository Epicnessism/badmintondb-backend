package com.wangindustries.badmintondbbackend.repositories;

import com.wangindustries.badmintondbbackend.Entities.RacketModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface RacketModelRepository extends CrudRepository<RacketModel, UUID>{
    @Override
    List<RacketModel> findAll();
}