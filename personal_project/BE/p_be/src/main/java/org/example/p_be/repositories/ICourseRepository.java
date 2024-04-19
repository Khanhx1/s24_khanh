package org.example.p_be.repositories;

import org.example.p_be.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepository extends JpaRepository<Course, Integer> {
}
