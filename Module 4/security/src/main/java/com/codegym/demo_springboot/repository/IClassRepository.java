package com.codegym.demo_springboot.repository;

import com.codegym.demo_springboot.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClassRepository extends JpaRepository<ClassRoom, Integer> {
}
