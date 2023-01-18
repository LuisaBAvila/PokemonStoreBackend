package com.example.sofka.domain.gateways;

import com.example.sofka.domain.Product;

import java.util.List;
import java.util.Optional;


public interface ProductRepository {
    Product createProductInventory(Product product);
    List<Product> findAllProductsInventory();
    Optional<Product> findProductById(String id);
    Product updateProduct(Product product);
    void deleteProduct(String id);
}
