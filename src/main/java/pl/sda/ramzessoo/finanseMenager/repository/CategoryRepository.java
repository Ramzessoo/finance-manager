package pl.sda.ramzessoo.finanseMenager.repository;

import jakarta.persistence.EntityManager;
import pl.sda.ramzessoo.finanseMenager.DbConnection;
import pl.sda.ramzessoo.finanseMenager.entity.Category;

public class CategoryRepository {

    public void insert(Category category){
        EntityManager entityManager = DbConnection.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(category);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void remove(Long categoryId){
        EntityManager entityManager = DbConnection.getEntityManager();
        entityManager.getTransaction().begin();
        Category category = entityManager.find(Category.class, categoryId);
        entityManager.remove(category);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
