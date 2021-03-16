//@Author Andrew Furey
//@Date: 3–15–2021
//@Email:
//@ClassName: PatientConfig

package com.example.illustris.patient;

import java.time.LocalDate;
import java.time.Month;
//import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PatientConfig {
    @Bean
    CommandLineRunner patientCommandLineRunner(PatientRepository repository){
        return args -> {
            Patient Frodo= new Patient("Frodo", "Bagins", "Took","fbagins@MidEarth.com", "555-555-5555", 
            LocalDate.of(1970, Month.APRIL, 15), false, false, false, false, "Peviously injured by cursed sword");

        
            repository.save(Frodo);
        };
    }
}
