package org.example.ss9_aop.models;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBook;
    private String nameBook;
    private String description;
    private Integer quantity;

    public Book() {
    }

    public Book(Integer idBook, String nameBook, String description, Integer quantity) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.description = description;
        this.quantity = quantity;
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
