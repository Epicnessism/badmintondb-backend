package com.wangindustries.badmintondbbackend.repositories;

import com.wangindustries.badmintondbbackend.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsersRepository extends CrudRepository<User, UUID> {
    User findByGivenNameOrFamilyName(@Param("given_name") String givenName, @Param("family_name") String familyName);
}
