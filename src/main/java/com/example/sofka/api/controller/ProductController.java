package com.example.sofka.api.controller;


import com.example.sofka.api.dtos.ProductDTO;
import com.example.sofka.domain.Product;
import com.example.sofka.domain.usecase.*;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Configuration
@RestController
@AllArgsConstructor
@RequestMapping("products")
public class ProductController {
    private final CreateProductInventoryUseCase createProductInventoryUseCase;
    private final FindAllProductsUseCase findAllProductsUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;
    private final FindProductByIdUseCase findProductByIdUseCase;


    @GetMapping("/Allproducts")
    public ResponseEntity<List<Product>> getAllproducts(){
        return new ResponseEntity<>( this.findAllProductsUseCase.apply(),HttpStatus.OK);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") String id){
        return  new ResponseEntity<>(
                this.findProductByIdUseCase.apply(id),HttpStatus.OK
        );
    }

    @PostMapping("/add")
    public ResponseEntity<Product> saveProduct(@RequestBody @Valid ProductDTO productDTO){
        return new ResponseEntity<>(
                this.createProductInventoryUseCase.apply(productDTO), HttpStatus.CREATED
        );
    }

    @PutMapping("/update/{id}")
    public  ResponseEntity<Product> updateProduct(@PathVariable("id") String id, @RequestBody @Valid ProductDTO productDTO){
        return new ResponseEntity<>(
                this.updateProductUseCase.apply(id, productDTO), HttpStatus.OK
        );
    }

    @DeleteMapping("/delteProduct/{id}")
    public void deleteProduct(@PathVariable("id") String id){
                this.deleteProductUseCase.apply(id);
    }

}
