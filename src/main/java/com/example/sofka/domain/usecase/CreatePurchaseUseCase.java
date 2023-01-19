package com.example.sofka.domain.usecase;

import com.example.sofka.api.dtos.PurchaseDTO;
import com.example.sofka.domain.Purchase;
import com.example.sofka.domain.SoldProduct;
import com.example.sofka.domain.gateways.PurchaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class CreatePurchaseUseCase {
    private final PurchaseRepository purchaseRepository;
    private final GetAllSoldProductsUseCase getAllSoldProductsUseCase;

    @Transactional
    public Purchase apply( PurchaseDTO purchaseDTO){

        var products = getAllSoldProductsUseCase.apply().stream().filter(product-> Objects.equals(product.getIdUser(), purchaseDTO.getIdClient()));
        List<SoldProduct> list= new ArrayList<>();
        products.forEach(list::add);

        Purchase purchase = new Purchase(purchaseDTO.getIdSale(),purchaseDTO.getDate(),
                purchaseDTO.getIdType(),
                purchaseDTO.getIdClient(),purchaseDTO.getClientName(), list );
        return this.purchaseRepository.createPurchase(purchase);
    }
}
