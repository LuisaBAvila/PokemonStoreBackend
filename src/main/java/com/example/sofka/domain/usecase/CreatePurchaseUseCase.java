package com.example.sofka.domain.usecase;

import com.example.sofka.api.dtos.PurchaseDTO;
import com.example.sofka.domain.Product;
import com.example.sofka.domain.Purchase;
import com.example.sofka.domain.gateways.PurchaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

@Service
@AllArgsConstructor
public class CreatePurchaseUseCase {
    private final PurchaseRepository purchaseRepository;
    private final FindProductByIdUseCase findProductByIdUseCase;

    @Transactional
    public Purchase apply(String id, PurchaseDTO purchaseDTO){
        HashSet<Product> listProducts = new HashSet<>();
        Product product = this.findProductByIdUseCase.apply(id);
        if(product.getInventory() <=0){
            throw new IllegalArgumentException("No hay producos disponibles");
        }

        listProducts.add(product);
        Purchase purchase = new Purchase(purchaseDTO.getIdSale(),purchaseDTO.getDate(),
                purchaseDTO.getIdType(),
                purchaseDTO.getIdClient(),purchaseDTO.getClientName(),listProducts);
        return this.purchaseRepository.createPurchase(purchase);
    }
}
