package org.example.shopping_cart.services;

import org.example.shopping_cart.models.Product;
import org.example.shopping_cart.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> getAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return iProductRepository.findById(id).orElse(null);
    }
}
