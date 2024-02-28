package org.example.ss9_aop.services;

import org.example.ss9_aop.models.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book getBookById(Integer id);

    void borrowBook(Integer id);

    void giveBack(Integer idBook);

    Boolean checkQuantity(Integer idBook);
}
