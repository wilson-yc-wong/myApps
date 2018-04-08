package net.myapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by chunwyc on 31/3/2018.
 */
//@EnableWebSecurity
public class SecurityConfig2 {//extends WebSecurityConfigurerAdapter {
//    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/css/**", "/*").permitAll()
                .antMatchers("/app/**").hasRole("USER")
                .and()
                .formLogin()
                .loginPage("/security/login").failureUrl("/security/login");
    }

//    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }

}
