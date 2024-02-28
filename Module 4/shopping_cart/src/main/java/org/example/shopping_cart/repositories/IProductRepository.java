package org.example.shopping_cart.repositories;

import org.example.shopping_cart.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer> {

}
