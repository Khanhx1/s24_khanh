package org.example.p_be.services;

import org.example.p_be.dto.ICourseDto;
import org.example.p_be.models.Course;
import org.example.p_be.models.OrderCourse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICourseService {
    Page<Course> getAll(Pageable pageable, String name, String sort, String category);

    Course findById(Integer id);

    List<Course> findAllCartByIdCustomer(Integer id);


}
