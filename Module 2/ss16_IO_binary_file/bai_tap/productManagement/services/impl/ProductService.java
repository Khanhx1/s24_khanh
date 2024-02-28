package ss16_IO_binary_file.bai_tap.productManagement.services.impl;

import ss16_IO_binary_file.bai_tap.productManagement.models.Product;
import ss16_IO_binary_file.bai_tap.productManagement.repositories.IProductRepository;
import ss16_IO_binary_file.bai_tap.productManagement.repositories.impl.ProductRepository;
import ss16_IO_binary_file.bai_tap.productManagement.services.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private IProductRepository productRepository = new ProductRepository();

    @Override
    public void addProduct(Product newProduct) {
        productRepository.addProduct(newProduct);
    }

    @Override
    public List<Product> findAllList() {
        return productRepository.findAllList();
    }

    @Override
    public Product findByCode(String code) {
        return productRepository.findByCode(code);
    }


}
