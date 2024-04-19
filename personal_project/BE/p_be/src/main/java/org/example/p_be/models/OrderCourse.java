package org.example.p_be.models;

import jakarta.persistence.*;

@Entity
@Table(name = "order_course")
public class OrderCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "id_course")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "id_receipt")
    private Receipt receipt;

    private Integer quantity;
    @Column(columnDefinition = "bit(1) default 0")
    private Boolean isDelete;

    public OrderCourse() {
    }

    public OrderCourse(Integer id, Customer customer, Course course, Receipt receipt, Integer quantity, Boolean isDelete) {
        this.id = id;
        this.customer = customer;
        this.course = course;
        this.receipt = receipt;
        this.quantity = quantity;
        this.isDelete = isDelete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }
}
