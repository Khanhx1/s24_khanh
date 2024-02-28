package com.example.mvc.repository.impl;

import com.example.mvc.model.Student;
import com.example.mvc.repository.IStudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private List<Student> students = new ArrayList<>();

    {
        students.add(new Student(1, "Truc Tham", 5d));
        students.add(new Student(2, "Quyen", 1d));
        students.add(new Student(3, "Thanh Dung", 6d));
        students.add(new Student(4, "Khanh", 7d));
        students.add(new Student(5, "Phap", 8d));
    }

    @Override
    public List<Student> getAllStudent() {
        return students;
    }

    @Override
    public void save(Student student) {
        this.students.add(student);
    }
}
