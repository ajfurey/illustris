package com.example.illustris.security;

import com.example.illustris.user.UserRole;
import com.example.illustris.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
    
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

   @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        String Admin = UserRole.Admin.roleUpCase();
        String Medical = UserRole.Medical.roleUpCase();
        String User = UserRole.User.roleUpCase();

        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userService);
        authenticationManager = authenticationManagerBuilder.build();

        http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(authorize -> authorize
        .requestMatchers("/admin/").hasRole(Admin)
        .requestMatchers("/user/**").hasAnyRole(Admin, User, Medical)
        .requestMatchers("/medical").hasAnyRole(Admin, Medical)
        .requestMatchers("/").permitAll()).formLogin(formLogin -> formLogin
        .successHandler(authenticationSuccessHandler())).logout(logout -> logout.permitAll());

        return http.build();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler(){
        return new IllustrisAuthenticationSuccessHandler();
    }

}
