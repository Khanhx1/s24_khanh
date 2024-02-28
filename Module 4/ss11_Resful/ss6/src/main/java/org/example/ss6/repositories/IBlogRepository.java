package org.example.ss6.repositories;

import org.example.ss6.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IBlogRepository extends JpaRepository<Blog, Integer> {
@Query(value = "select * from blog where title = :search", nativeQuery = true)
    List<Blog> findByName(@Param("search")String search);
}
