package org.example.ss8_validate_1.services;

import org.example.ss8_validate_1.models.User;
import org.example.ss8_validate_1.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public void add(User user) {
        iUserRepository.save(user);
    }
}
