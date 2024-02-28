package vn.codegym.service;

import vn.codegym.model.Student;

import java.util.List;

public interface IStudentService {
    //CRUD Sort, Search...
    List<Student> findAll();

    void save(Student student);

    //validate
}
