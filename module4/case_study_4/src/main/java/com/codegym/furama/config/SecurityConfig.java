package com.codegym.furama.config;

import com.codegym.furama.repositories.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsServiceImpl userDetailService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
        return memory;
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/img/**", "/customize/**", "/jquery/**", "/dis/**", "/vendor1/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        // nếu chưa login sẽ chuyển hướng tới trang login
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/**").access("hasAnyRole('ROLE_EMPLOYEE','ROLE_CEO','ROLE_EMPLOYEE')")
                .antMatchers("/employees/**").access("hasAnyRole('ROLE_EMPLOYEE','ROLE_CEO')");

        // submit url của trang login
        http.authorizeRequests().and().formLogin()
                // submit url của trang login
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/employees")
                .usernameParameter("username")
                .passwordParameter("password")
                // cấu hình cho logout page
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login");

        // cấu hình rememberme
        http.authorizeRequests().and()
                .rememberMe().tokenRepository(this.persistentTokenRepository())
                .tokenValiditySeconds(10 * 60); //10 phút
    }
}
