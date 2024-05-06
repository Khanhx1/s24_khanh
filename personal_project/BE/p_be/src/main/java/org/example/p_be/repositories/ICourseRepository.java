package org.example.p_be.repositories;

import org.example.p_be.dto.ICourseDto;
import org.example.p_be.models.Course;
import org.example.p_be.models.OrderCourse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICourseRepository extends JpaRepository<Course, Integer> {

    @Query(value = "SELECT course.id, course.audio, course.description, course.extra_description, course.img, \n" +
            "course.instructor, course.is_delete, course.name, course.price, course.target_lesson, \n" +
            "course.title_chapter, course.total_user, course.video_demo, \n" +
            "GROUP_CONCAT(category.name ORDER BY category.name SEPARATOR ',') AS categories\n" +
            "FROM course\n" +
            "JOIN course_category ON course_category.id_course = course.id\n" +
            "JOIN category ON course_category.id_category = category.id\n" +
            "where :name is null or course.name like concat('%',:name,'%')\n" +
            "GROUP BY course.id \n" +
            "ORDER BY \n" +
            "  CASE \n" +
            "    WHEN :fieldSort IS NULL THEN course.id \n" +
            "    WHEN :fieldSort = 'price' and :orderSort = 'desc' then price\n" +
            "    WHEN :fieldSort = 'total_user' and :orderSort = 'desc' then total_user\n" +
            "  END desc,\n" +
            "  CASE \n" +
            "    WHEN :fieldSort IS NULL THEN course.id \n" +
            "    WHEN :fieldSort = 'price' and :orderSort = 'asc' then price\n" +
            "  END asc;", nativeQuery = true)
    Page<Course> getAllCourse(Pageable pageable, @Param("name") String name, @Param("fieldSort") String fieldSort, @Param("orderSort") String orderSort);


    @Query(value = "SELECT course.id, course.audio, course.description, course.extra_description, course.img, \n" +
            "course.instructor, course.is_delete, course.name, course.price, course.target_lesson, \n" +
            "course.title_chapter, course.total_user, course.video_demo, \n" +
            "GROUP_CONCAT(category.name ORDER BY category.name SEPARATOR ',') AS categories\n" +
            "FROM course\n" +
            "JOIN course_category ON course_category.id_course = course.id\n" +
            "JOIN category ON course_category.id_category = category.id\n" +
            "where :name is null or category.name in (:category) and course.name like concat('%',:name,'%')\n" +
            "GROUP BY course.id\n" +
            "HAVING COUNT(DISTINCT category.id) >= :length \n" +
            "ORDER BY \n" +
            "  CASE \n" +
            "    WHEN :fieldSort IS NULL THEN course.id \n" +
            "    WHEN :fieldSort = 'price' and :orderSort = 'desc' then price\n" +
            "    WHEN :fieldSort = 'total_user' and :orderSort = 'desc' then total_user\n" +
            "  END desc,\n" +
            "  CASE \n" +
            "    WHEN :fieldSort IS NULL THEN course.id \n" +
            "    WHEN :fieldSort = 'price' and :orderSort = 'asc' then price\n" +
            "  END asc;", nativeQuery = true)
    Page<Course> getAllCourseSearchCategory(Pageable pageable,@Param("name") String name,@Param("category") String[] category,@Param("length") Integer length, @Param("fieldSort") String fieldSort, @Param("orderSort") String orderSort);


    @Query(value = "SELECT course.id, course.audio, course.description, course.extra_description, course.img, \n" +
            "course.instructor, course.is_delete, course.name, course.price, course.target_lesson, \n" +
            "course.title_chapter, course.total_user, course.video_demo, \n" +
            "GROUP_CONCAT(category.name ORDER BY category.name SEPARATOR ',') AS categories\n" +
            "FROM course\n" +
            "JOIN course_category ON course_category.id_course = course.id\n" +
            "JOIN category ON course_category.id_category = category.id\n" +
            "where course.id = :id  \n" +
            "GROUP BY course.id", nativeQuery = true)
    Course findCourseById(@Param("id") Integer id);


    @Query(value = "SELECT course.id, course.audio, course.description, course.extra_description, course.img, \n" +
            "course.instructor, course.is_delete, course.name, course.price, course.target_lesson, \n" +
            "course.title_chapter, course.total_user, course.video_demo, \n" +
            "GROUP_CONCAT(category.name ORDER BY category.name SEPARATOR ',') AS categories\n" +
            "FROM course\n" +
            "JOIN course_category ON course_category.id_course = course.id\n" +
            "JOIN category ON course_category.id_category = category.id\n" +
            "join order_course on order_course.id_course = course.id\n" +
            "where order_course.id_receipt is null and order_course.id_customer = :id \n" +
            "GROUP BY course.id", nativeQuery = true)
    List<Course> findAllCartById(@Param("id") Integer id);
}
