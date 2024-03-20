package com.codegym.demo_springboot.repository;

import com.codegym.demo_springboot.model.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IStudentRepository extends JpaRepository<Student, Integer> {
    //Khi method có làm thay đổi dữ liệu trong DB thì cần sử dụng 2 annotation là Transactional, Modifying
//    @Modifying
//    @Transactional
//    nativeQuery = true => SQL
//    nativeQuery = false (mặc đinịnh) => HQL
    @Query(value = "select * from student as s where name_student = :name", nativeQuery = true)
    List<Student> findAllByNameStudentContaining(@Param("name") String name);
}
