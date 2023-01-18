package com.example.sofka.infrastructure.postgres;

import com.example.sofka.domain.Product;
import com.example.sofka.domain.gateways.ProductRepository;
import com.example.sofka.infrastructure.adapters.IProductRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRespositoryAdapter implements ProductRepository {
    private final IProductRepository iProductRepository;

    public ProductRespositoryAdapter(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }

    @Override
    public Product createProductInventory(Product product) {
        return this.iProductRepository.save(product);
    }

    @Override
    public List<Product> findAllProductsInventory() {
        return this.iProductRepository.findAll();
    }

    @Override
    public Optional<Product> findProductById(String id) {
        return this.iProductRepository.findById(id);
    }

    @Override
    public Product updateProduct(Product product) {
        return this.iProductRepository.save(product);
    }

    @Override
    public void deleteProduct(String id) {
        this.iProductRepository.deleteById(id);

    }
}
