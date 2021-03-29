package com.example.illustris.user;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    
    @Bean
    CommandLineRunner userCommandLineRunner(UserRepository repository){
        return args -> {
            User Nick = new User("nfury01", "nfury@shield.com", "GooseIsNotAC@", true, "ROLE_ADMIN");
            User Hannah = new User("hsmith04","yeahnah@gmail.com", "1", true, "ROLE_USER");
            repository.saveAll(List.of(Nick, Hannah));
        };
        
    }
}
