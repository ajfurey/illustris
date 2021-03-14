package com.example.illustris.user;

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
            User Hannah= new User("Hannah", "Smith", "yeahnah@gmail.com", "password", "111-111-1111", LocalDate.of(1993, Month.JANUARY, 1));
            repository.save(Hannah);
        };
    }
}/**/
