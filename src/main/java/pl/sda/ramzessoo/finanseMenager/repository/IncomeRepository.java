package pl.sda.ramzessoo.finanseMenager.repository;

import jakarta.persistence.EntityManager;
import pl.sda.ramzessoo.finanseMenager.DbConnection;
import pl.sda.ramzessoo.finanseMenager.entity.Income;

public class IncomeRepository {

    public void insert(Income income) {
        EntityManager entityManager = DbConnection.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(income);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void remove(Long Id) {
        EntityManager entityManager = DbConnection.getEntityManager();
        entityManager.getTransaction().begin();
        Income income = entityManager.find(Income.class, Id);
        entityManager.remove(income);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
