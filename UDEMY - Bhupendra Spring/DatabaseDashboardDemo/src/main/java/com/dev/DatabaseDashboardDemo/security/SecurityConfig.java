package com.dev.DatabaseDashboardDemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Autowired
    private LoginSuccessHandler loginSuccessHandler;
    @Autowired
    private LoginDeniedHandler loginDeniedHandler;
    
    @Autowired
    private DataSource dataSource;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/*.css", "/createUser").permitAll()
                .antMatchers("/", "/**", "/css/**", "/static/**").hasAnyRole("ADMIN", "USER")
                .anyRequest().authenticated()
                .and()
                .formLogin().successHandler(loginSuccessHandler)
                .loginPage("/login")
                .permitAll()
                .and()
                .logout().invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(loginDeniedHandler).and().csrf().disable();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        
        
        auth.jdbcAuthentication().dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("select username as username, password, true"
                + " from credentials where username=?")
                .authoritiesByUsernameQuery("select username as username, role"
                        + " from credentials where username=?");
         
    }
    
    
}
