package com.example.sofka.domain.usecase;

import com.example.sofka.domain.Product;
import com.example.sofka.domain.gateways.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindProductByIdUseCase {
    private final ProductRepository productRepository;
    public Product apply(String id){
        return this.productRepository.findProductById(id).orElse(null);
    }
}
