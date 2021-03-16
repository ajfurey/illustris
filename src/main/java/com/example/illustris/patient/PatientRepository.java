//@Author Andrew Furey
//@Date: 3–15–2021
//@Email:
//@ClassName: PatientRepository

package com.example.illustris.patient;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

    Optional<Patient> findPatientByEmail(String email);
    
}
