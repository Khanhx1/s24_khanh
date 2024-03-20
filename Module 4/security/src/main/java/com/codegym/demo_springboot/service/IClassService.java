package com.codegym.demo_springboot.service;

import com.codegym.demo_springboot.model.ClassRoom;

import java.util.List;

public interface IClassService {
    List<ClassRoom> findAll();
}
