package pl.sda.ramzessoo.finanseMenager.repository;

import jakarta.persistence.EntityManager;
import pl.sda.ramzessoo.finanseMenager.DbConnection;
import pl.sda.ramzessoo.finanseMenager.entity.Category;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CategoryRepository {

    public void insert(Category category) {
        EntityManager entityManager = DbConnection.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(category);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Set<Category> finfAll() {
        EntityManager entityManager = DbConnection.getEntityManager();
        List<Category> categories = entityManager
                .createQuery("From cateogry", Category.class)
                .getResultList();

        return new HashSet<>(categories);
    }

    public void remove(Long categoryId) {
        EntityManager entityManager = DbConnection.getEntityManager();
        entityManager.getTransaction().begin();
        Category category = entityManager.find(Category.class, categoryId);
        entityManager.remove(category);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
