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
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String Admin=UserRole.Admin.roleUpCase();
        String Medical=UserRole.Medical.roleUpCase();
        String User=UserRole.User.roleUpCase();
        http.csrf().disable().authorizeRequests()
                .antMatchers("/admin/").hasRole(Admin)
                .antMatchers("/user/**").hasAnyRole(Admin, User, Medical)
                .antMatchers("/medical").hasAnyRole(Admin, Medical)
                .antMatchers("/").permitAll()
                .and().formLogin()
                .successHandler(authenticationSuccessHandler())
                .and().logout().permitAll();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean("authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler(){
        return new IllustrisAuthenticationSuccessHandler();
    }

}
