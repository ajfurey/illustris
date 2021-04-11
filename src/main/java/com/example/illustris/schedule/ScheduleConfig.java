package com.example.illustris.schedule;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScheduleConfig {
    @Bean
    CommandLineRunner scheduleCommandLineRunner(ScheduleRepository repository){
        return args -> {
            //Schedule appt1= new Schedule(LocalDateTime.of(2021, Month.MAY, 2, 10,45), 1l, 1, LocalDateTime.of(2021, Month.APRIL, 5, 7,54), LocalDateTime.now());
            //repository.saveAll(List.of(appt1));
        };
        
    }
}
