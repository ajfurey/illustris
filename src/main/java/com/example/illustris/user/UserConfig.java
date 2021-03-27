//@Author Andrew Furey
//@Date: 3–15–2021
//@Email:
//@ClassName: UserConfig

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
            User Nick = new User("Nick", "Fury", "nfury01", "nfury@shield.com", "GooseIsNotAC@", "555-555-5555",
            LocalDate.of(1970, Month.APRIL, 15), true, UserRole.ADMIN, true, false, "Doctor",
            LocalDate.of(1987, Month.JANUARY, 1));

            User Hannah = new User("Hannah", "Smith", "hsmith04","yeahnah@gmail.com", "password", "111-111-1111",
            LocalDate.of(1993, Month.JANUARY, 1), true, UserRole.MEDICAL, true, false, "Technician", 
            LocalDate.of(2015, Month.JUNE, 15));

            User John = new User("John", "Terry", "jterry02","jmoney@bingo.com", "pass01", "222-222-2222",
            LocalDate.of(1985, Month.FEBUARY, 7), true, UserRole.USER, true, false, "Reception", 
            LocalDate.of(2015, Month.JUNE, 15));
            
            repository.saveAll(List.of(Nick, Hannah, John));
        };
    }
}/**/
