package com.example.illustris.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    @Query("SELECT s FROM User s WHERE s.username = ?1")
    Optional<User> findByUsername(String username);
}
