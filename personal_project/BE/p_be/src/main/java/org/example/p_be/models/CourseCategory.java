package org.example.p_be.models;

import jakarta.persistence.*;

@Entity
@Table(name = "course_category")
public class CourseCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_course")
    private Course course;
    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    public CourseCategory() {
    }

    public CourseCategory(Integer id, Course course, Category category) {
        this.id = id;
        this.course = course;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
