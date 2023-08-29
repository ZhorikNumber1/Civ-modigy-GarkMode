package com.civmodapi;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CivModApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CivModApiApplication.class, args);
        Flyway flyway = Flyway.configure().load(); // Загрузка конфигурации из файла по умолчанию (flyway.yml)
        flyway.migrate(); // Запуск миграций базы данных

    }

}
