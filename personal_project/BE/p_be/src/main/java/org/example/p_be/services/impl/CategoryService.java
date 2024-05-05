package org.example.p_be.services.impl;

import org.example.p_be.models.Category;
import org.example.p_be.repositories.ICategoryRepository;
import org.example.p_be.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }
}
