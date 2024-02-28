package ss16_IO_binary_file.bai_tap.productManagement.services;

import ss16_IO_binary_file.bai_tap.productManagement.models.Product;

import java.util.List;

public interface IProductService {
    void addProduct(Product newProduct);

    List<Product> findAllList();

    Product findByCode(String code);
}
