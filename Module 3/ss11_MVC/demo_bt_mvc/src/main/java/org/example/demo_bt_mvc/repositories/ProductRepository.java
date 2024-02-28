package org.example.demo_bt_mvc.repositories;

import org.example.demo_bt_mvc.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository{
    private List<Product> productList = new ArrayList<>();
    {
        productList.add(new Product("1", "px11", 12, 50 ));
        productList.add(new Product("2", "px12", 17, 40 ));
        productList.add(new Product("3", "px13", 65, 20 ));


    }

    @Override
    public List<Product> getAll() {
        return productList;
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public void remove(String id) {
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getId().equals(id)){
                productList.remove(productList.get(i));
                break;
            }
        }
    }

    @Override
    public void edit(String id, String newId, String newName, Integer newQuantity, Integer newPrice) {

        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId().equals(id)) {
                productList.get(i).setId(newId);
                productList.get(i).setName(newName);
                productList.get(i).setQuantity(newQuantity);
                productList.get(i).setPrice(newPrice);
                break;
            }

        }

        }

    @Override
    public Product findById(String id) {
        Product detailProduct = null;
        for (Product product: productList) {
            if(product.getId().equals(id)) {
                detailProduct = product;
                break;
            }
        }
        return detailProduct;
    }
}

