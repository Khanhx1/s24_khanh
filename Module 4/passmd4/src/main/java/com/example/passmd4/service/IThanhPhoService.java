package com.example.passmd4.service;

import com.example.passmd4.model.ThanhPho;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IThanhPhoService {
    Page<ThanhPho> findAllThanhPho(Pageable pageable);

    List<ThanhPho> findAllThanhPho();

    void createThanhPho(ThanhPho thanhPho);

    ThanhPho findThanhPhoById(Integer id);

     void updateThanhPho(ThanhPho thanhPho);

    void deleteThanhPho(Integer id);

    List<ThanhPho> getThanhPhoByQuocGiaId(Integer quocGiaId);

    Page<ThanhPho> searchThanhPhoByTenThanhPhoContaining(String tenThanhPho, Pageable pageable);
}

