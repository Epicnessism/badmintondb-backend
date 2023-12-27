package com.wangindustries.badmintondbbackend.repositories;

import com.wangindustries.badmintondbbackend.Entities.Stringing;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface StringingRepository extends CrudRepository<Stringing, UUID> {

    Stringing getByStringingId(@Param("stringingId") UUID stringingId);

    List<Stringing> findByStringerUserId(@Param("stringingUserId") UUID stringerUserId);

    List<Stringing> findByRequesterUserId(@Param("requesterUserId") UUID requesterUserId);

    List<Stringing> findByStringerUserIdOrRequesterUserId(@Param("stringingUserId") UUID userId, @Param("requesterUserId") UUID requesterUserId);

    List<Stringing> findByStringerUserIdAndIsCompleted(@Param("stringingUserId") UUID stringerUserId, @Param("isCompleted") boolean isCompleted);

    List<Stringing> findByRequesterUserIdAndIsCompleted(@Param("requesterUserId") UUID requesterUserId, @Param("isCompleted") boolean isCompleted);

    @Query("SELECT s FROM Stringing s where (s.stringer.userId = ?1 or s.requester.userId = ?2) and s.isCompleted = ?3")
    List<Stringing> findByStringerUserIdOrRequesterUserIdAndIsCompleted(@Param("stringingUserId") UUID stringerUserId, @Param("requesterUserId") UUID requesterUserId, @Param("isCompleted") boolean isCompleted);
}
