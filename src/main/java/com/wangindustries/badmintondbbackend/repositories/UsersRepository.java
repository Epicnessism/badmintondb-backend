package com.wangindustries.badmintondbbackend.repositories;

import com.wangindustries.badmintondbbackend.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UsersRepository extends CrudRepository<User, UUID> {
    User findByGivenNameOrFamilyName(@Param("given_name") String givenName, @Param("family_name") String familyName);

    User findByUsername(@Param("username") String username);

    User findByUserId(@Param("user_id") UUID userId);

    List<User> findByIsStringerTrue();
}
