package com.example.TestMediaSoft.repos.personRepo;

import com.example.TestMediaSoft.entities.personEntities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This class contains a method to search for a user by name and allows User entities to interact with the database.
 */
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
