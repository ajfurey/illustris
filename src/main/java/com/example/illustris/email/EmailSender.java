package com.example.illustris.email;

import org.springframework.context.annotation.Bean;

public interface EmailSender {
    @Bean
    void send(String to, String email);
}
