package pl.sda.ramzessoo.finanseMenager.repository;

import jakarta.persistence.EntityManager;
import pl.sda.ramzessoo.finanseMenager.DbConnection;
import pl.sda.ramzessoo.finanseMenager.entity.Expense;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExpenseRepository {

    public void insert(Expense expense) {
        EntityManager entityManager = DbConnection.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(expense);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Set<Expense> findAll() {
        EntityManager entityManager = DbConnection.getEntityManager();
        List<Expense> expenses = entityManager
                .createQuery("From expense", Expense.class)
                .getResultList();

        return new HashSet<>(expenses);
    }

    public void remove(Long Id) {
        EntityManager entityManager = DbConnection.getEntityManager();
        entityManager.getTransaction().begin();
        Expense expense = entityManager.find(Expense.class, Id);
        entityManager.remove(expense);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
