package com.example.passmd4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThanhPho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tenThanhPho;
    private double dienTich;
    private Long danSo;
    private Double GDP;
    private String moTa;
    @ManyToOne
    @JoinColumn(name = "id_quocgia", referencedColumnName = "id")
    private QuocGia quocGia;
}
