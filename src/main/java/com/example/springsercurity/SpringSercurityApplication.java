package com.example.springsercurity;

import com.example.springsercurity.entity.Role;
import com.example.springsercurity.entity.User;
import com.example.springsercurity.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;

@SpringBootApplication
@EnableWebSecurity
@EnableJpaRepositories
public class SpringSercurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSercurityApplication.class, args);
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    CommandLineRunner run(UserService userService){
//        return args -> {
//            userService.saveRole(new Role(null,"ROLE_USER"));
//            userService.saveRole(new Role(null,"ROLE_MANAGER"));
//            userService.saveRole(new Role(null,"ROLE_ADMIN"));
//            userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));
//
//            userService.saveUser(new User(null,"Nguyen Hai Long","Long","longnhph42034@fpt.edu.vn","123456",new HashSet<>()));
//            userService.saveUser(new User(null,"Nguyen Phuong Nam","Nam","nam123@gmail.com","123456",new HashSet<>()));
//
//            userService.addToUser("longnhph42034@fpt.edu.vn","ROLE_ADMIN");
//            userService.addToUser("longnhph42034@fpt.edu.vn","ROLE_SUPER_ADMIN");
//
//            userService.addToUser("nam123@gmail.com","ROLE_USER");
//            userService.addToUser("nam123@gmail.com ,","ROLE_MANAGER");
//
//        };
//    }
}
