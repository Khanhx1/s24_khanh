package ss16_IO_binary_file.bai_tap.productManagement.controllers;

import ss16_IO_binary_file.bai_tap.productManagement.models.Product;
import ss16_IO_binary_file.bai_tap.productManagement.services.IProductService;
import ss16_IO_binary_file.bai_tap.productManagement.services.impl.ProductService;

import java.util.List;

public class ProductController {
    private IProductService productService = new ProductService();

    public void addProduct(Product newProduct) {
        productService.addProduct(newProduct);
    }

    public List<Product> findAllList() {
        return productService.findAllList();
    }

    public Product findByCode(String code) {
        return productService.findByCode(code);
    }
}
