package com.example.mvc.service;

import com.example.mvc.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAllStudent();

    void save(Student student);
}
