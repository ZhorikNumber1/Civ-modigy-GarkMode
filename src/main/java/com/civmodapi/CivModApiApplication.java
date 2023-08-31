package com.civmodapi;

import com.civmodapi.Model.Role;
import com.civmodapi.Model.User;
import com.civmodapi.Repository.RoleRepository;
import com.civmodapi.Repository.UserRepository;
import org.flywaydb.core.Flyway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class CivModApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CivModApiApplication.class, args);
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/dbCiv", "root", "123")
                .schemas("public")
                .locations("filesystem:E:/Simple-CRUD-java-app/src/main/resources/db/migration")
                .load();
        flyway.migrate();

    }
    @Bean
    CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncode){
        return args ->{
            if(roleRepository.findByAuthority("ADMIN").isPresent()) return;
            Role adminRole = roleRepository.save(new Role("ADMIN"));
            roleRepository.save(new Role("USER"));

            Set<Role> roles = new HashSet<>();
            roles.add(adminRole);

            User admin = new User(1, "admin", passwordEncode.encode("password"), roles);

            userRepository.save(admin);
        };
    }
}
