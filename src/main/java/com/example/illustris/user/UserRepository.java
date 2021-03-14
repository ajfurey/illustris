package com.example.illustris.user;

import java.util.Optional;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    //SELECT * FROM student WHERE email= ?
    @Query("SELECT u FROM User u WHERE u.email = ?1")//User is class not db
    Optional<User> findUserByEmail(String email);
}
