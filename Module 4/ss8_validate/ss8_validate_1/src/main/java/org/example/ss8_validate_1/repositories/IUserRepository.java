package org.example.ss8_validate_1.repositories;

import org.example.ss8_validate_1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
