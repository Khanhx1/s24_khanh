package org.example.p_be.services.impl;

import org.example.p_be.dto.ICourseDto;
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
    public Page<Course> getAll(Pageable pageable, String name, String sort, String category) {
        Integer length = null;
        String[] arrCategory;
        String fieldSort = "";
        String orderSort = "";

        switch (sort) {
            case "popular":
                fieldSort = "total_user";
                orderSort = "desc";
                break;
            case "lowestPrice":
                fieldSort = "price";
                orderSort = "asc";
                break;
            case "highestPrice":
                fieldSort = "price";
                orderSort = "desc";
                break;
        }
        if (!category.isEmpty()){
             arrCategory = category.split(",");
             length = arrCategory.length;
             return iCourseRepository.getAllCourseSearchCategory(pageable, name, arrCategory, length, fieldSort, orderSort);
        }

        return iCourseRepository.getAllCourse(pageable, name, fieldSort, orderSort);
    }

    @Override
    public Course findById(Integer id) {
        return iCourseRepository.findCourseById(id);
    }
}
