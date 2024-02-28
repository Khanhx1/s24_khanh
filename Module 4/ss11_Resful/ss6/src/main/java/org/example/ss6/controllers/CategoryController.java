package org.example.ss6.controllers;

import org.example.ss6.models.Category;
import org.example.ss6.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public ResponseEntity<List<Category>> getAll() {
        return new ResponseEntity<>(iCategoryService.getAll(), HttpStatus.OK);
    }
}
