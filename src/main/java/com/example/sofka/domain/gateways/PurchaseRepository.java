package com.example.sofka.domain.gateways;

import com.example.sofka.domain.Product;
import com.example.sofka.domain.Purchase;

import java.util.List;

public interface PurchaseRepository {
    Purchase createPurchase( Purchase purchase);
    List<Purchase> findAllSales();
}
