package com.example.passmd4.service;

import com.example.passmd4.model.ThanhPho;
import com.example.passmd4.repo.IThanhPhoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThanhPhoService implements IThanhPhoService {
    @Autowired
    private IThanhPhoRepo iThanhPhoRepo;

    @Override
    public Page<ThanhPho> findAllThanhPho(Pageable pageable) {
        return iThanhPhoRepo.findAll(pageable);
    }

    @Override
    public List<ThanhPho> findAllThanhPho() {
        return iThanhPhoRepo.findAll();
    }

    @Override
    public void createThanhPho(ThanhPho thanhPho) {
        iThanhPhoRepo.save(thanhPho);
    }

    @Override
    public ThanhPho findThanhPhoById(Integer id) {
        return iThanhPhoRepo.findById(id).get();
    }

    @Override
    public void updateThanhPho(ThanhPho thanhPho) {
        iThanhPhoRepo.save(thanhPho);
    }

    @Override
    public void deleteThanhPho(Integer id) {
        iThanhPhoRepo.deleteById(id);
    }

    @Override
    public List<ThanhPho> getThanhPhoByQuocGiaId(Integer quocGiaId) {
        return iThanhPhoRepo.getThanhPhoByQuocGiaId(quocGiaId);
    }

    @Override
    public Page<ThanhPho> searchThanhPhoByTenThanhPhoContaining(String tenThanhPho, Pageable pageable) {
        return iThanhPhoRepo.searchThanhPhoByTenThanhPhoContaining(tenThanhPho, pageable);
    }

}
