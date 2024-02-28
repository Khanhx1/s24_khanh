package org.example.demo.repositories;

import org.example.demo.models.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository{
    private static List<Product> productList;
    static {
        Product product1 = new Product(1,"Product1", 10, 12);
        Product product2 = new Product(2,"Product2", 20, 15);
        Product product3 = new Product(3,"Product3", 30, 36);
        Product product4 = new Product(4,"Product4", 40, 88);

        productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
    }
    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        for(Product product: productList){
            if(product.getId() == id){
                return product;
            }
        }
        return null;
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getId() == id){
                productList.remove(i);
                break;
            }
        }
    }

    @Override
    public void edit(Product product) {
        for (int i = 0; i < productList.size(); i++){
            if(product.getId() == productList.get(i).getId()){
                productList.get(i).setName(product.getName());
                productList.get(i).setPrice(product.getPrice());
                productList.get(i).setQuantity(product.getQuantity());
                break;
            }
        }
    }

    @Override
    public List<Product> search(String search) {
        List<Product> products = new ArrayList<>();
        for (Product product: productList){
            if(product.getName().equals(search)){
                products.add(product);
            }
        }
        return products;
    }
}
