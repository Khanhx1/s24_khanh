package org.example.ss6.controllers;

import org.example.ss6.models.Category;
import org.example.ss6.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public String showList(Model model){
       List<Category> categories = iCategoryService.getAll();
       model.addAttribute("list",categories);
       return "/category/list";
    }
    @GetMapping("/create")
    public String showCreatePage(Model model){
        model.addAttribute("category", new Category());
        return "/category/create";
    }
    @PostMapping("/create")
    public String createCategory(@ModelAttribute("category")Category category){
        iCategoryService.save(category);
        return "redirect:/category";
    }
    @GetMapping("/edit/{id}")
    public String showEditPage(@ModelAttribute("id")Integer id,Model model){
        Category category = iCategoryService.findById(id);
        model.addAttribute("category", category);
        return "/category/edit";
    }
    @PostMapping("/edit")
    public String editCategory(@ModelAttribute("category")Category category){
        iCategoryService.update(category);
        return "redirect:/category";
    }
    @GetMapping("/delete/{id}")
    public String deleteCategory(@ModelAttribute("id")Integer id){
        iCategoryService.deleteCategory(id);
        return "redirect:/category";
    }
}
