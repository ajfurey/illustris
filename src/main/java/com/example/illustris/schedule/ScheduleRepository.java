package com.example.illustris.schedule;

import java.time.LocalDateTime;
import java.util.Optional;

import com.example.illustris.patient.Patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long>{
    @Query("SELECT s FROM Schedule s WHERE s.apptTime = ?1")
    Optional<Schedule> findApptByApptTime(LocalDateTime apptTime);
    /*@Query("SELECT s FROM Schedule s WHERE s.startTime = ?1")
    Optional<Schedule> findByStartTime(String username);*/

}
