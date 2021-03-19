//@Author Andrew Furey
//@Date: 3–15–2021
//@Email:
//@ClassName: PatientController                   

package com.example.illustris.patient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/Patient")
public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
	public List<Patient> getPatients(){
		return patientService.getPatients();
	}

    @PostMapping
    public void registerNewUser(@RequestBody Patient patient){
        patientService.addNewPatient(patient);
    }
    
    @DeleteMapping(path= "{patientId}")
    public void deleteUser(@PathVariable("patientId") Long patientId){
        patientService.deletePatient(patientId);
    }

    @PutMapping(path ="{patientId}")
    public void uadatePatient(
        @PathVariable("patientId") Long patientId,
        @RequestParam(required = false) String lastName,
        @RequestParam(required = false) String email
    ){
        patientService.uadatePatient(patientId, lastName, email);
    }
}
