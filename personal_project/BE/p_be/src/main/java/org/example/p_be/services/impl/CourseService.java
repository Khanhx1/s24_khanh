package org.example.p_be.services.impl;

import org.example.p_be.models.Course;
import org.example.p_be.repositories.ICourseRepository;
import org.example.p_be.services.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CourseService implements ICourseService {
    @Autowired
    private ICourseRepository iCourseRepository;
    @Override
    public Page<Course> getAll(Pageable pageable) {
        return iCourseRepository.findAll(pageable);
    }

    @Override
    public Course findById(Integer id) {
        return iCourseRepository.findById(id).orElse(null);
    }
}
