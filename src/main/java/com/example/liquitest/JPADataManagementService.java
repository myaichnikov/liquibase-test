package com.example.liquitest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Slf4j
public class JPADataManagementService implements DataManagementService {

    private final EntityManager entityManager;

    public JPADataManagementService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void applyScript(String script) {
        Query nativeQuery = entityManager.crea(script);
        try {
            int i = nativeQuery.();
        } catch (Exception e) {
            log.debug(e.getMessage());
        }
    }
}
