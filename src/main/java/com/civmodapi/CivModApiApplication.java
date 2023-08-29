package com.civmodapi;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

}
