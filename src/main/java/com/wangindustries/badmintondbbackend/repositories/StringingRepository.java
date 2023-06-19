package com.wangindustries.badmintondbbackend.repositories;

import com.wangindustries.badmintondbbackend.entities.Stringing;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface StringingRepository extends CrudRepository<Stringing, UUID> {}
