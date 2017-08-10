package com.example.liquitest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class AppConfiguration {

    @Bean
    public DataManagementService dataManagementService(EntityManager entityManager) {
        return new JPADataManagementService(entityManager);
    }

}
