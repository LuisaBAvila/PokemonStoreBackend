package com.example.sofka.api.controller;

import com.example.sofka.api.dtos.PurchaseDTO;
import com.example.sofka.domain.Purchase;
import com.example.sofka.domain.usecase.CreatePurchaseUseCase;
import com.example.sofka.domain.usecase.GetAllRegisterUseCase;
import com.example.sofka.domain.usecase.GetAllSoldProductsUseCase;
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
@RequestMapping("sale")
public class PurchaseController {
    private final CreatePurchaseUseCase createPurchaseUseCase;
    private final GetAllRegisterUseCase getAllRegisterUseCase;

    @PostMapping("/product")
    public ResponseEntity<Purchase> postPurchase( @RequestBody @Valid PurchaseDTO purchaseDTO){
        return new ResponseEntity<>(
                this.createPurchaseUseCase.apply(purchaseDTO), HttpStatus.CREATED
        );
    }

    @GetMapping("/allRegister")
    public ResponseEntity<List<Purchase>> getAllRegister(){
        return new ResponseEntity<>(
                this.getAllRegisterUseCase.apply(),HttpStatus.OK
        );
    }
}
