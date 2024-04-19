package org.example.p_be.controllers;

import org.example.p_be.models.Course;
import org.example.p_be.services.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private ICourseService iCourseService;

    @GetMapping("")
    public ResponseEntity<?> getAll(@RequestParam(name = "page", defaultValue = "0")int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Course> coursePage = iCourseService.getAll(pageable);
        return new ResponseEntity<>(coursePage, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getCourse(@PathVariable("id")Integer id) {
        Course course = iCourseService.findById(id);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }
}
