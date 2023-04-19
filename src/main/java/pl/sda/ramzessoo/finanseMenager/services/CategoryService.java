
package pl.sda.ramzessoo.finanseMenager.services;

import pl.sda.ramzessoo.finanseMenager.entity.Category;
import pl.sda.ramzessoo.finanseMenager.repository.CategoryRepository;

public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void addCategory(String name) {
        Category category = new Category(name);
        category.setName(name);
        categoryRepository.insert(category);

    }


    public void removeCategory(Category category) {
        categoryRepository.remove(category.getId());
    }

}

