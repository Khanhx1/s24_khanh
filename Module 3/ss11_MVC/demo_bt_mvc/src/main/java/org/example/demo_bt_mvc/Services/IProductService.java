package org.example.demo_bt_mvc.Services;

import org.example.demo_bt_mvc.models.Product;

import java.util.List;

public interface IProductService {

    List<Product> getAll();

    void add(Product product);

    void remove(String id);

    void edit(String id, String newId, String newName, Integer newQuantity, Integer newPrice);

    Product findById(String id);
}
