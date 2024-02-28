package org.example.demo_bt_mvc.Services;

import org.example.demo_bt_mvc.models.Product;
import org.example.demo_bt_mvc.repositories.IProductRepository;
import org.example.demo_bt_mvc.repositories.ProductRepository;

import java.util.List;

public class ProductService implements IProductService{
    private IProductRepository productRepository = new ProductRepository();

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public void remove(String id) {
        productRepository.remove(id);
    }

    @Override
    public void edit(String id, String newId, String newName, Integer newQuantity, Integer newPrice) {
        productRepository.edit(id, newId, newName, newQuantity, newPrice);
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id);
    }
}
