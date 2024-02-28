package com.example.mvc.repository;

import com.example.mvc.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> getAllStudent();

    void save(Student student);
}
