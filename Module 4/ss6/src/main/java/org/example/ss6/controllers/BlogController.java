package org.example.ss6.controllers;

import org.example.ss6.models.Blog;
import org.example.ss6.services.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String showList(Model model) {
        List<Blog> blogList = blogService.getAllBlog();
        model.addAttribute("blogList", blogList);
        return "list";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String createBlog(@ModelAttribute("blog") Blog blog) {
        blogService.saveBlog(blog);
        return "redirect:/blog";
    }

    @GetMapping("/detail/{id}")
    public String showBlog(@PathVariable("id")Integer id, Model model){
        Blog blog = blogService.getBlogById(id);
        model.addAttribute("blog", blog);
        return "blog";
    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable("id")Integer id){
        blogService.deleteBlog(id);
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public String ShowEditBlog(@PathVariable("id")Integer id, Model model){
        Blog blog = blogService.getBlogById(id);
        model.addAttribute("blog", blog);
        return "edit";
    }
    @PostMapping("/edit")
    public String editBlog(@ModelAttribute("Blog")Blog blog){
        blogService.saveBlog(blog);
        return "redirect:/blog";
    }
}
