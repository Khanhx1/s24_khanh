package org.example.ss6.services;

import org.example.ss6.models.Category;
import org.example.ss6.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryRepository iCategoryRepository;
    @Override
    public List<Category> getAll() {
      return iCategoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public Category findById(Integer id) {
        return iCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Integer id) {
        iCategoryRepository.deleteById(id);
    }

}
