//@Author Andrew Furey
//@Date: 3–15–2021
//@Email:
//@ClassName: PatientService

package com.example.illustris.patient;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    public void addNewPatient(Patient patient) {
        Optional<Patient> patientOptional = patientRepository.
        findPatientByBirthDate(patient.getBirthDate());
		if (patientOptional.isPresent()) {
			throw new IllegalStateException("This Patient Exists");//TODO: use an error message
		}
		patientRepository.save(patient);
    }

    public void deletePatient(Long patientId) {
        boolean exists=patientRepository.existsById(patientId);
		if (!exists) {
			throw new IllegalStateException("patient with id "+ patientId + " does not exist");//TODO: use an error message
		}
		patientRepository.deleteById(patientId);
    }

    public void uadatePatient(Long patientId, String lastName, LocalDate birthDate) {
        Patient patient = patientRepository.findById(patientId)
		.orElseThrow(() ->new IllegalStateException(
			"user with id "+ patientId + " does not exist"));//TODO: use an error message

		if (lastName != null && lastName.length() >0 && 
		!Objects.equals(patient.getLastName(), lastName)) {
			patient.setLastName(lastName);
		}
		if (birthDate != null && 
		!Objects.equals(patient.getBirthDate(), birthDate)) {
			Optional<Patient> patientOptional = patientRepository
			.findPatientByBirthDate(birthDate);
			if (patientOptional.isPresent()) {
				throw new IllegalStateException("email taken");//TODO: use an error message
			}
			patient.setBirthDate(birthDate);
		}
    }
}
