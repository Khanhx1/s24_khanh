package vn.codegym.repository;

import vn.codegym.model.Student;

import java.util.List;

public interface IStudentRepository {
    //CRUD Sort, Search...
    List<Student> findAll();

    void save(Student student);
}
