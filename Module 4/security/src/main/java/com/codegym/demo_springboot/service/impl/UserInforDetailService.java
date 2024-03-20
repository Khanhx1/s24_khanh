package com.codegym.demo_springboot.service.impl;

import com.codegym.demo_springboot.dto.UserInfoUserDetails;
import com.codegym.demo_springboot.model.AppUser;
import com.codegym.demo_springboot.model.UserRole;
import com.codegym.demo_springboot.repository.IUserRepository;
import com.codegym.demo_springboot.repository.IUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserInforDetailService implements UserDetailsService {
    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private IUserRoleRepository iUserRoleRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = iUserRepository.findByUserName(username);
        List<UserRole> userRoles = iUserRoleRepository.findAllByAppUser(appUser);
        UserInfoUserDetails infoUserDetails = new UserInfoUserDetails(appUser, userRoles);
        return infoUserDetails;
    }
}
