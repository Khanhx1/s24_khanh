package com.codegym.demo_springboot.service.impl;

import com.codegym.demo_springboot.model.Student;
import com.codegym.demo_springboot.repository.IStudentRepository;
import com.codegym.demo_springboot.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository iStudentRepository;
    @Override
    public List<Student> getAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        this.iStudentRepository.save(student);
    }

    @Override
    public Student getStudentById(int id) {
        return iStudentRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Student> getAll(Pageable pageable) {
        return iStudentRepository.findAll(pageable);
    }
}
