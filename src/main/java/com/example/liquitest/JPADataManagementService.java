package com.example.liquitest;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class JPADataManagementService implements DataManagementService {

    private final EntityManager entityManager;

    public JPADataManagementService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void applyScript(String script) {
        Query nativeQuery = entityManager.createNativeQuery(script);
        int i = nativeQuery.executeUpdate();
    }
}
