package com.codegym.demo_springboot.repository;

import com.codegym.demo_springboot.model.AppUser;
import com.codegym.demo_springboot.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findAllByAppUser(AppUser appUser);
}
