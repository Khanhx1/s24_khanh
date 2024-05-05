package org.example.p_be.services;

import org.example.p_be.models.User;

public interface IUserService {
    User findUserByUsername(String username);
}
