package vn.codegym.service;

import vn.codegym.model.Student;
import vn.codegym.repository.IStudentRepository;
import vn.codegym.repository.StudentRepositoryImpl;

import java.util.List;

/**
 * (C) Copyright 2023 iHub Academy. All Rights Reserved.
 *
 * @author TrungDC
 * @version 1.0
 * @since 12/29/2023
 */
public class StudentServiceImpl implements IStudentService{
    private IStudentRepository repository = new StudentRepositoryImpl();
    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Student student) {
        repository.save(student);
    }
}