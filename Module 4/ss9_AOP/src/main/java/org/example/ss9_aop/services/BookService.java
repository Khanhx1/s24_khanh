package org.example.ss9_aop.services;

import org.example.ss9_aop.models.Book;
import org.example.ss9_aop.repositories.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public Book getBookById(Integer id) {
        return iBookRepository.findById(id).orElse(null);
    }

    @Override
    public void borrowBook(Integer id) {
        Book book = iBookRepository.findById(id).orElse(null);
        Book book1 = new Book(book.getIdBook(), book.getNameBook(), book.getDescription(), book.getQuantity() - 1);
        iBookRepository.save(book1);
    }

    @Override
    public void giveBack(Integer idBook) {
        Book book = iBookRepository.findById(idBook).orElse(null);
        if (book != null) {
            Book book1 = new Book(book.getIdBook(), book.getNameBook(), book.getDescription(), book.getQuantity() + 1);
            iBookRepository.save(book1);
        }
    }

    @Override
    public Boolean checkQuantity(Integer idBook) {
        Book book = getBookById(idBook);
        if(book.getQuantity().equals(0)){
            return false;
        }
        return true;
    }


}
