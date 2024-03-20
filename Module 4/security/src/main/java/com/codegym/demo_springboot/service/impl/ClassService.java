package com.codegym.demo_springboot.service.impl;

import com.codegym.demo_springboot.model.ClassRoom;
import com.codegym.demo_springboot.repository.IClassRepository;
import com.codegym.demo_springboot.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService implements IClassService {
    @Autowired
    private IClassRepository iClassRepository;

    @Override
    public List<ClassRoom> findAll() {
        return iClassRepository.findAll();
    }
}
