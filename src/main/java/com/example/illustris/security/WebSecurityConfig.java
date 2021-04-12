package com.example.illustris.security;

//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

//import com.example.illustris.user.UserRole;
//import com.example.illustris.user.UserService;

//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;

//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


//this is a redundent class to be used as an example
//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig{
/*public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public WebSecurityConfig(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
        
        //http.authorizeRequests()
        .antMatchers("/admin").hasRole(UserRole.ADMIN.toString())
        .antMatchers("/api/v1/User").hasAnyRole(UserRole.ADMIN.toString(),
        UserRole.USER.toString(), UserRole.MEDICAL.toString())
        .antMatchers("/medical").hasAnyRole(UserRole.ADMIN.toString(),UserRole.MEDICAL.toString())
        .antMatchers("/api/v/Registration/**").permitAll()
        .antMatchers("/").permitAll()
        .anyRequest().authenticated().and().formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(userService);
        return provider;
    }*/
    
}