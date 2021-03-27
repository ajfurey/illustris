//@Author Andrew Furey
//@Date: 3–15–2021
//@Email:
//@ClassName: UserRepository

package com.example.illustris.user;

import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Long>{
    //SELECT * FROM student WHERE email= ?
    @Query("SELECT s FROM User s WHERE s.email = ?1")//User is class not db
    Optional<User> findUserByEmail(String email);

    Optional<User> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE User a " + "SET a.enabled = TRUE WHERE a.email = ?1")
    

    int enableUser(String email);

}
