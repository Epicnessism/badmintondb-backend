package com.wangindustries.badmintondbbackend.repositories;

import com.wangindustries.badmintondbbackend.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UsersRepository extends CrudRepository<User, UUID> {}
