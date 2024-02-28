package org.example.ss6.models;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "date")
    private LocalDate date = getDateNow();
    @Column(name = "content", columnDefinition = "LONGTEXT")
    private String content;

    public Blog() {
    }

    public LocalDate getDateNow(){
        LocalDate currentDate = LocalDate.now();
        return currentDate;
    }

    public Blog(Integer id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
