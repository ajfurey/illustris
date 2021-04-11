//@Author Andrew Furey
//@Date: 3–15–2021
//@Email:
//@ClassName: PatientRepository

package com.example.illustris.patient;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
    @Query("SELECT p FROM Patient p WHERE p.birthDate = ?1")
    Optional<Patient> findPatientByBirthDate(LocalDate birthDate);
    
    @Query("SELECT p FROM Patient p WHERE p.birthDate = ?1 and p.lastName = ?2")
    Optional<Patient> findPatientByBirthDateAndLastName(LocalDate birthDate, String lastName);

    @Query("SELECT p FROM Patient p WHERE p.id = ?1")
    Patient find(Long id);
    
}
