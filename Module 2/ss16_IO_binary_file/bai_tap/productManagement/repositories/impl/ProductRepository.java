package ss16_IO_binary_file.bai_tap.productManagement.repositories.impl;

import ss16_IO_binary_file.bai_tap.productManagement.models.Product;
import ss16_IO_binary_file.bai_tap.productManagement.repositories.IProductRepository;
import ss16_IO_binary_file.bai_tap.productManagement.util.ReadObject;
import ss16_IO_binary_file.bai_tap.productManagement.util.WriteObject;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private List<Product> productList = new ArrayList<>();
    private WriteObject writeObject = new WriteObject();
    private ReadObject readObject = new ReadObject();

    @Override
    public void addProduct(Product newProduct) {
        productList.add(newProduct);
        writeObject.writeObjectListIntoFile(productList);
    }

    @Override
    public List<Product> findAllList() {
        return readObject.readObjectList();
    }

    @Override
    public Product findByCode(String code) {
        List<Product> productList = this.findAllList();
        for (Product product : productList) {
            if (product.getCode().equals(code)) {
                return product;
            }
        }
        return null;
    }
}
