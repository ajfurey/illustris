//@Author Andrew Furey
//@Date: 3–15–2021
//@Email:
//@ClassName: OrderConfig

package com.example.illustris.order;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {
    @Bean
    CommandLineRunner orderCommandLineRunner(OrderRepository repository){
        return args -> {
            Order Basic= new Order(LocalDateTime.of(2021, Month.MARCH, 15, 7,54,02,01), LocalDateTime.now(), "Broken Leg", "Leg", Modality.XRay, "Um... This is a broken action figure not a person");
            repository.save(Basic);
        };
    }
}
