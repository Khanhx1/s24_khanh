package org.example.ss9_aop.models;

import jakarta.persistence.*;

@Entity
@Table(name = "borrowing")
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBorrowing;
    private Integer BorrowingCode;
    @ManyToOne
    @JoinColumn(name = "id_book")
    private Book book;

    public Borrowing() {
    }

    public Borrowing(Integer idBorrowing, Integer borrowingCode, Book book) {
        this.idBorrowing = idBorrowing;
        BorrowingCode = borrowingCode;
        this.book = book;
    }

    public Borrowing(Integer randomCode, Book book) {
    }

    public Integer getIdBorrowing() {
        return idBorrowing;
    }

    public void setIdBorrowing(Integer idBorrowing) {
        this.idBorrowing = idBorrowing;
    }

    public Integer getBorrowingCode() {
        return BorrowingCode;
    }

    public void setBorrowingCode(Integer borrowingCode) {
        BorrowingCode = borrowingCode;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
