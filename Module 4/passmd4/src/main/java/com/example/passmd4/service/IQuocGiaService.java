package com.example.passmd4.service;

import com.example.passmd4.model.QuocGia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IQuocGiaService {
    List<QuocGia> findAllQuocGia();

    Page<QuocGia> findAllQuocGia(Pageable pageable);

    void createQuocGia(QuocGia quocGia);

    void updateQuocGia(QuocGia quocGia);

    void deleteQuocGia(Integer id);

    QuocGia findQuocGiaById(Integer id);
}
