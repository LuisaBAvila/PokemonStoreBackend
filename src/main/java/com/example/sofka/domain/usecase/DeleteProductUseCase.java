package com.example.sofka.domain.usecase;

import com.example.sofka.domain.Product;
import com.example.sofka.domain.gateways.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class DeleteProductUseCase {
    private final ProductRepository productRepository;

    @Transactional
    public void apply(String id){
        this.productRepository.deleteProduct(id);
    }
}
