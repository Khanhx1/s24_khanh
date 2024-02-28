package org.example.ss6.repositories;

import org.example.ss6.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
