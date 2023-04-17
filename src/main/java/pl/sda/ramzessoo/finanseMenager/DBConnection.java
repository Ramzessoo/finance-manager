package pl.sda.ramzessoo.finanseMenager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DBConnection {
    private static final EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("finance-manager");

    public static EntityManager entityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public static void closeEntityManagerFactory() {
        entityManagerFactory.close();
    }

}
