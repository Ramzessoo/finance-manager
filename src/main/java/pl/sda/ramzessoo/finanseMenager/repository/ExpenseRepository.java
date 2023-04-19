package pl.sda.ramzessoo.finanseMenager.repository;

import jakarta.persistence.EntityManager;
import pl.sda.ramzessoo.finanseMenager.DbConnection;
import pl.sda.ramzessoo.finanseMenager.entity.Expense;

public class ExpenseRepository {

    public void insert(Expense expense) {
        EntityManager entityManager = DbConnection.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(expense);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Expense showAll(){
        return null;
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
