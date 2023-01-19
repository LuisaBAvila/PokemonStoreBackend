package com.example.sofka.api.controller;

import com.example.sofka.api.dtos.SoldProductDTO;
import com.example.sofka.domain.SoldProduct;
import com.example.sofka.domain.usecase.CreateSoldProductUseCase;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Configuration
@RestController
@AllArgsConstructor
@RequestMapping("sold")
public class SoldProdcutController {
    private final CreateSoldProductUseCase createSoldProductUseCase;

    @PostMapping("product/{id}")
    public ResponseEntity<SoldProduct> saveSoldProdcut(@PathVariable("id") String id,
                                          @RequestBody @Valid SoldProductDTO soldProductDTO){
        return new ResponseEntity<>(
                this.createSoldProductUseCase.apply(id,soldProductDTO), HttpStatus.CREATED
        );
    }
}
