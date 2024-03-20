package com.codegym.demo_springboot.model;


import com.codegym.demo_springboot.utils.annotation.NameConstraint;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Entity(name = "student")
public class Student implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //HD-001, HD-002
    @Column(name = "code_student")
    private Integer codeStudent;
    @Column(name = "name_student", columnDefinition = "VARCHAR(100)")
    @Size(min = 3, max = 100, message = "Tên không được ngắn quá 3 ký tự và dài quá 100 ký tự")
//    @Pattern(regexp = "[a-z ]{4,100}", message = "Tên không đúng định dạng")
    @NameConstraint(message = "Tên sai định dạng. VD: Trương Tấn Hải")
    private String nameStudent;
    @Min(value = 0, message = "Điểm không được nhỏ hơn 0")
    @Max(value = 10, message = "Điểm không được lớn hơn 0")
    private Double point;
    private Integer gender;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassRoom classRoom;

    public Student() {
    }

    public Student(int codeStudent, String nameStudent, double point, Integer gender) {
        this.codeStudent = codeStudent;
        this.nameStudent = nameStudent;
        this.point = point;
        this.gender = gender;
    }

    public Integer getCodeStudent() {
        return codeStudent;
    }

    public void setCodeStudent(Integer codeStudent) {
        this.codeStudent = codeStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
       Student student = (Student) target;
       if(!student.nameStudent.matches("[a-z ]{4,10}")) {
           errors.rejectValue("nameStudent", "", "Tên không đúng định dạng");
       }
    }
}
