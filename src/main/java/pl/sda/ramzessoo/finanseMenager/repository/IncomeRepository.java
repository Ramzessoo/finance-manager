package pl.sda.ramzessoo.finanseMenager.repository;

import jakarta.persistence.EntityManager;
import pl.sda.ramzessoo.finanseMenager.DbConnection;
import pl.sda.ramzessoo.finanseMenager.entity.Income;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncomeRepository {

    public void insert(Income income) {
        EntityManager entityManager = DbConnection.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(income);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Set<Income> findAll(){
        EntityManager entityManager = DbConnection.getEntityManager();
        List<Income> incomes = entityManager
                .createQuery("From income", Income.class)
                .getResultList();
        return new HashSet<>(incomes);
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
