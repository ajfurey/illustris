package com.example.illustris.user;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    
    @Bean
    CommandLineRunner userCommandLineRunner(UserRepository repository){
        return args -> {
            User Nick = new User("Nick", "Fury", "nfury01", "nfury@shield.com", "pass", "555-555-5555", 
            "420 Stark Stn. Gainesville, GA 30504",Title.Admin, LocalDate.of(1987, Month.JANUARY, 1), true, false, "ROLE_ADMIN");
            User Hannah = new User("Hannah", "Smith", "hsmith04","yeahnah@gmail.com", "pass", "111-111-1111", 
            "516 Mockingbird Ln. Atlanta, GA 30307", Title.Radiologist, LocalDate.of(2015, Month.JUNE, 15), true, false, "ROLE_MEDICAL");
            User John = new User("John", "Terry", "jterry02","jmoney@bingo.com", "pass", "222-222-2222", 
            "899 Mockingbird Ln. Dahlonega, GA 30533", Title.Receptionist, LocalDate.of(2015, Month.JUNE, 15), true, false, "ROLE_USER");
            repository.saveAll(List.of(Nick, Hannah, John));
        };
        
    }
}
