package com.example.passmd4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "quocgia_thanhpho")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuocGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tenQuocGia;
    @OneToMany(mappedBy = "quocGia")
    private Set<ThanhPho> thanhPhos;

}
