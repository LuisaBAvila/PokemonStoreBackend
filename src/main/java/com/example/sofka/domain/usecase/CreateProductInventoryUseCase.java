package com.example.sofka.domain.usecase;

import com.example.sofka.api.dtos.ProductDTO;
import com.example.sofka.domain.Product;
import com.example.sofka.domain.gateways.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CreateProductInventoryUseCase {
    private ProductRepository productRepository;

    @Transactional
    public Product apply(ProductDTO productDTO){
        Product product = new Product(productDTO.getId(),productDTO.getName(),
                productDTO.getInventory(),productDTO.getEnabled(),
                productDTO.getMinProducts(), productDTO.getMaxProducts());
        return this.productRepository.createProductInventory(product);
    }

}
