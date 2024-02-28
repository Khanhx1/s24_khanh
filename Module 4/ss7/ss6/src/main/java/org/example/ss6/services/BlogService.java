package org.example.ss6.services;

import org.example.ss6.models.Blog;
import org.example.ss6.repositories.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> getAllBlog() {
        return blogRepository.findAll();
    }

    @Override
    public void saveBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void deleteBlog(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Blog getBlogById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> searchByName(String search) {
        return blogRepository.findByName(search);
    }
}
