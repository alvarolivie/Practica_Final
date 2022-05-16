package Peroli.Practica_Final.config;

import java.util.HashMap;
import java.util.Map;

import Peroli.Practica_Final.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ServiceUser serviceUser;

    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder;
    }



    @Override
    public void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                //.and();

                .authorizeRequests()
                .antMatchers("/","/Arroces.html","/Comienzo.html","/Contacto.html","/index.html","/Pedido.html","/Pedido2.html","/Servicios.html","/css/**","/resources/**","/js/**","/auth/login", "elPeroli/v1/cliente/**").permitAll() //las url que no necesitan auth (login y esas)
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/auth/login").permitAll()
                .defaultSuccessUrl("/GestorPedidos.html");


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(serviceUser).passwordEncoder(passwordEncoder());
    }

}
