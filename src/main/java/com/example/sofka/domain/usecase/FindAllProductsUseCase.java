package com.example.sofka.domain.usecase;

import com.example.sofka.domain.Product;
import com.example.sofka.domain.gateways.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FindAllProductsUseCase {

    private final ProductRepository productRepository;

    public List<Product> apply(){
        return this.productRepository.findAllProductsInventory();
    }
}
