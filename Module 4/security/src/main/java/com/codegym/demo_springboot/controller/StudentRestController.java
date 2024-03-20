package com.codegym.demo_springboot.controller;

import com.codegym.demo_springboot.model.Student;
import com.codegym.demo_springboot.service.IStudentService;
import com.codegym.demo_springboot.service.impl.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/student")
@CrossOrigin("*")
public class StudentRestController {
    @Autowired
    private IStudentService iStudentService;

    @GetMapping("")
    public ResponseEntity<List<Student>> getList() {
        return new ResponseEntity<>(iStudentService.getAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Void> save(@Valid @RequestBody Student student){
       iStudentService.save(student);
       return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    @DeleteMapping("{id}")
//    @PutMapping("{id}")
//    @PatchMapping("{id}")

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
