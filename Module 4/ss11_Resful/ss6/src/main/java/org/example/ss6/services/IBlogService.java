package org.example.ss6.services;

import org.example.ss6.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> getAllBlog();
    void saveBlog(Blog blog);
    void deleteBlog(Integer id);
    Blog getBlogById(Integer id);

    List<Blog> searchByName(String search);

    Page<Blog> findAll(Pageable pageable);
}
