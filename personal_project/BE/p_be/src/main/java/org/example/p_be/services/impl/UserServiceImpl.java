package org.example.p_be.services.impl;

import org.example.p_be.models.User;
import org.example.p_be.repositories.IUserRepository;
import org.example.p_be.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;
    @Override
    public User findUserByUsername(String username) {
        return iUserRepository.findUserByUsername(username);
    }
}
