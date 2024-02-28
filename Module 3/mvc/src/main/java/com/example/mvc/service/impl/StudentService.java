package com.example.mvc.service.impl;

import com.example.mvc.model.Student;
import com.example.mvc.repository.IStudentRepository;
import com.example.mvc.repository.impl.StudentRepository;
import com.example.mvc.service.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {
    private IStudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> getAllStudent() {
        return this.studentRepository.getAllStudent();
    }

    @Override
    public void save(Student student) {
        this.studentRepository.save(student);
    }
}
