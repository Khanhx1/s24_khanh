package org.example.ss6.controllers;

import org.example.ss6.models.Blog;
import org.example.ss6.services.IBlogService;
import org.example.ss6.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public ResponseEntity<List<Blog>> getAll() {
//        return new ResponseEntity<>(blogService.findAll(PageRequest.of(0, 2)), HttpStatus.OK);
        return new ResponseEntity<>(blogService.findAllList(), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Blog> getDetail(@PathVariable Integer id) {
        return new ResponseEntity<>(blogService.getBlogById(id), HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<Blog>> findByName(@RequestBody String title){
        return new ResponseEntity<>(blogService.findByName(title), HttpStatus.OK);
    }


}
