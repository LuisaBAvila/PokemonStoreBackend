package com.example.sofka.domain.gateways;

import com.example.sofka.domain.Purchase;

public interface PurchaseRepository {
    Purchase createPurchase( Purchase purchase);
}
