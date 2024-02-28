package org.example.ss9_aop.services;

import org.example.ss9_aop.models.Book;
import org.springframework.stereotype.Service;

@Service
public interface IBorrowingService {
    Integer addBorrowing(Book book);

    Integer findIdBook(Integer randomCode);

    void deleteBorrowing(Integer randomCode);
}
