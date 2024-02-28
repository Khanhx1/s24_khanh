package org.example.demo.services;

import org.example.demo.models.Product;
import org.example.demo.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void remove(int id) {
        productRepository.remove(id);
    }

    @Override
    public void edit(Product product) {
        productRepository.edit(product);
    }

    @Override
    public List<Product> search(String search) {
        return productRepository.search(search);
    }
}
