package ss16_IO_binary_file.bai_tap.productManagement.repositories;

import ss16_IO_binary_file.bai_tap.productManagement.models.Product;

import java.util.List;

public interface IProductRepository {
    void addProduct(Product newProduct);


    List<Product> findAllList();

    Product findByCode(String code);
}
