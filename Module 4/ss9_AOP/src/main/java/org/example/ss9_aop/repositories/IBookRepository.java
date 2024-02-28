package org.example.ss9_aop.repositories;

import org.example.ss9_aop.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Integer> {
}
