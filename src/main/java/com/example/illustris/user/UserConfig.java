package com.example.illustris.user;

import java.util.List;
import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            User Andy= new User("Andy", "Furey", "ajfure6252@gmail.com", "password", "555-555-5555", LocalDate.of(1991, Month.APRIL, 15));

            repository.saveAll(List.of(Andy));
        };
    }
}
