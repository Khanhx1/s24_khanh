package com.example.passmd4.repo;

import com.example.passmd4.model.QuocGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuocGiaRepo extends JpaRepository<QuocGia,Integer> {
}

