package com.example.sofka.api.controller;


import com.example.sofka.api.dtos.ProductDTO;
import com.example.sofka.domain.Product;
import com.example.sofka.domain.usecase.CreateProductInventoryUseCase;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Configuration
@RestController
@RequestMapping("products")
public class ProductController {
    private final CreateProductInventoryUseCase createProductInventoryUseCase;

    public ProductController(CreateProductInventoryUseCase createProductInventoryUseCase) {
        this.createProductInventoryUseCase = createProductInventoryUseCase;
    }

    @PostMapping("/add")
    public ResponseEntity<Product> saveProduct(@RequestBody @Valid ProductDTO productDTO){
        return new ResponseEntity<>(
                this.createProductInventoryUseCase.apply(productDTO), HttpStatus.CREATED
        );
    }
}
