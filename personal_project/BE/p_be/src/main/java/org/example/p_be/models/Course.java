package org.example.p_be.models;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String Instructor;
    private String img;
    private String audio;

    private Integer price;
    @Column(columnDefinition = "bit(1) default 0")
    private Boolean isDelete;
    @Column(columnDefinition = "text")
    private String description;

    @Column(columnDefinition = "text")
    private String extraDescription;

    @Column(columnDefinition = "text")
    private String titleChapter;

    @Column(columnDefinition = "text")
    private String targetLesson;
    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    public Course() {
    }

    public Course(Integer id, String name, String instructor, String img, String audio, Integer price, Boolean isDelete, String description, String extraDescription, String titleChapter, String targetLesson, Category category) {
        this.id = id;
        this.name = name;
        Instructor = instructor;
        this.img = img;
        this.audio = audio;
        this.price = price;
        this.isDelete = isDelete;
        this.description = description;
        this.extraDescription = extraDescription;
        this.titleChapter = titleChapter;
        this.targetLesson = targetLesson;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructor() {
        return Instructor;
    }

    public void setInstructor(String instructor) {
        Instructor = instructor;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExtraDescription() {
        return extraDescription;
    }

    public void setExtraDescription(String extraDescription) {
        this.extraDescription = extraDescription;
    }

    public String getTitleChapter() {
        return titleChapter;
    }

    public void setTitleChapter(String titleChapter) {
        this.titleChapter = titleChapter;
    }

    public String getTargetLesson() {
        return targetLesson;
    }

    public void setTargetLesson(String targetLesson) {
        this.targetLesson = targetLesson;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
