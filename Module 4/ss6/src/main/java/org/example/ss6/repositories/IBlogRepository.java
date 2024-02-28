package org.example.ss6.repositories;

import org.example.ss6.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface IBlogRepository extends JpaRepository<Blog, Integer> {

}
