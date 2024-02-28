package org.example.ss9_aop.repositories;

import org.example.ss9_aop.models.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowingRepository extends JpaRepository<Borrowing, Integer> {
}
