package com.wangindustries.badmintondbbackend.repositories;

import com.wangindustries.badmintondbbackend.Entities.Stringing;
import com.wangindustries.badmintondbbackend.models.AggregateStringingDataByStringerUserId;
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


    //get aggregate values by user for stringings
    @Query("SELECT new com.wangindustries.badmintondbbackend.models.AggregateStringingDataByStringerUserId(" +
            "s.stringer.userId as stringerUserId, " +
            "COUNT(*) as totalCount," +
            "SUM(price) as totalPrice," +
            "AVG(price) as totalAveragePrice," +
            "COALESCE(SUM(1) FILTER (WHERE s.isCompleted = true AND s.stringer.userId <> s.requester.userId), 0) as totalCompletedStringsNotIncludingUser," +
            "min(price) as minimumPrice," +
            "max(price) as maximumPrice," +
            "COALESCE(SUM(1) FILTER (WHERE s.isCompleted = true), 0) as numberOfCompleted," +
            "COALESCE(SUM(1) FILTER (WHERE s.isCompleted = false), 0) as numberNotCompleted)" +
            "FROM Stringing s where s.stringer.userId = :stringerUserId " +
            "GROUP BY s.stringer.userId")
    List<AggregateStringingDataByStringerUserId> getAggregateDataByStringerUserId(@Param("stringerUserId") UUID stringerUserId);
}
