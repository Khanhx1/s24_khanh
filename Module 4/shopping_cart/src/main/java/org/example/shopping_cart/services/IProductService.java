package org.example.shopping_cart.services;

import org.example.shopping_cart.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();

    Product findById(Integer id);
}
