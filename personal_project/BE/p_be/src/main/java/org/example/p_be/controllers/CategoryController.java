package org.example.p_be.controllers;

import org.example.p_be.models.Category;
import org.example.p_be.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;
    @GetMapping("")
    public ResponseEntity<?> getAll() {
        String a = "a";
        List<Category> categories = iCategoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
