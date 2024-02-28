package org.example.ss8_validate_1.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Size(min = 5, max = 45, message = "Tên không nhỏ hơn 5 ký tự và lớn hơn 45 ký tự")
    private String firstName;
    @NotEmpty
    @Size(min = 5, max = 45, message = "Tên không nhỏ hơn 5 ký tự và lớn hơn 45 ký tự")
    private String lastName;
    @Pattern(regexp = "^0[0-9]{9}$", message = "Số điện thoại không đúng định dạng")
    private String phoneNumber;
    @NotNull
    @Min(value = 18, message = "Phải đủ 18 tuổi")
    private Integer age;
    @Email
    private String email;

    public User() {
    }

    public User(Integer id, String firstName, String lastName, String phoneNumber, Integer age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
