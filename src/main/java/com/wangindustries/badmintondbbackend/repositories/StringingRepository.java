package com.wangindustries.badmintondbbackend.repositories;

import com.wangindustries.badmintondbbackend.entities.Stringing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface StringingRepository extends CrudRepository<Stringing, UUID> {

    Stringing getByStringingId(@Param("stringingId") UUID stringingId);

    List<Stringing> findByStringerUserId(@Param("stringingUserId") UUID stringerUserId);

    List<Stringing> findByStringerUserIdAndIsCompleted(@Param("stringingUserId") UUID stringerUserId, @Param("isCompleted") boolean isCompleted);
}
