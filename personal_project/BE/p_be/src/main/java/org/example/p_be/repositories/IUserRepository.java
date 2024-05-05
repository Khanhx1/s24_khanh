package org.example.p_be.repositories;

import org.example.p_be.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {

    User findUserByUsername(String username);
}
