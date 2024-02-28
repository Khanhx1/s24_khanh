package com.example.passmd4.service;

import com.example.passmd4.model.QuocGia;
import com.example.passmd4.repo.IQuocGiaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuocGiaService implements IQuocGiaService {
    @Autowired
    private IQuocGiaRepo iQuocGiaRepo;

    @Override
    public List<QuocGia> findAllQuocGia() {
        return iQuocGiaRepo.findAll();
    }

    @Override
    public Page<QuocGia> findAllQuocGia(Pageable pageable) {
        return iQuocGiaRepo.findAll(pageable);
    }

    @Override
    public void createQuocGia(QuocGia quocGia) {
        iQuocGiaRepo.save(quocGia);
    }

    @Override
    public void updateQuocGia(QuocGia quocGia) {
        iQuocGiaRepo.save(quocGia);
    }

    @Override
    public void deleteQuocGia(Integer id) {
        iQuocGiaRepo.findById(id);
    }

    @Override
    public QuocGia findQuocGiaById(Integer id) {
        return iQuocGiaRepo.findById(id).get();
    }
}
