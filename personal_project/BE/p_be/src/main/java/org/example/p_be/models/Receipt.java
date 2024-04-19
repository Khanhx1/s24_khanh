package org.example.p_be.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "receipt")
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private LocalDate date;
    private Integer totalAmount;

    public Receipt() {
    }

    public Receipt(Integer id, String code, LocalDate date, Integer totalAmount) {
        this.id = id;
        this.code = code;
        this.date = date;
        this.totalAmount = totalAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }
}
