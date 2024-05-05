package org.example.p_be.repositories;

import org.example.p_be.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {

}
