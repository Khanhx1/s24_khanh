package org.example.demo.repositories;

import org.example.demo.models.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void add(Product product);

    Product findById(int id);

    void remove(int id);

    void edit(Product product);

    List<Product> search(String search);
}
