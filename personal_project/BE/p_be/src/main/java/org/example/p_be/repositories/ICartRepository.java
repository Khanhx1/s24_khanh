package org.example.p_be.repositories;

import org.example.p_be.models.OrderCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartRepository extends JpaRepository<OrderCourse, Integer> {
}
