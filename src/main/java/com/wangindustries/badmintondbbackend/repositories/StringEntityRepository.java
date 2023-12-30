package com.wangindustries.badmintondbbackend.repositories;

import com.wangindustries.badmintondbbackend.Entities.StringEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface StringEntityRepository extends CrudRepository<StringEntity, UUID> {
}
