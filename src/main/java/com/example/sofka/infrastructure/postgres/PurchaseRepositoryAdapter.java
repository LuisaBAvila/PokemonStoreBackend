package com.example.sofka.infrastructure.postgres;

import com.example.sofka.domain.Purchase;
import com.example.sofka.domain.gateways.PurchaseRepository;
import com.example.sofka.infrastructure.adapters.IPurchaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class PurchaseRepositoryAdapter implements PurchaseRepository {
    private final IPurchaseRepository iPurchaseRepository;
    @Override
    public Purchase createPurchase(Purchase purchase) {
        return this.iPurchaseRepository.save(purchase);
    }
}
