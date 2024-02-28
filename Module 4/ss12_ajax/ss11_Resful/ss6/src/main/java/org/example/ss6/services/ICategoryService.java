package org.example.ss6.services;

import org.example.ss6.models.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAll();

    void save(Category category);

    Category findById(Integer id);

    void update(Category category);

    void deleteCategory(Integer id);
}
