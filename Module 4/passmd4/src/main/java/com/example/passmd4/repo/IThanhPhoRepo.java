package com.example.passmd4.repo;

import com.example.passmd4.model.ThanhPho;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IThanhPhoRepo extends JpaRepository<ThanhPho,Integer> {
        @Query(nativeQuery = true,value = "select * from thanh_pho where id_quocgia = :param")
        List<ThanhPho> getThanhPhoByQuocGiaId(@Param("param") Integer idQuocGia);
        Page<ThanhPho> searchThanhPhoByTenThanhPhoContaining(String tenThanhPho, Pageable pageable);
    }


