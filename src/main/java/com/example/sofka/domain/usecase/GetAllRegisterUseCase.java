package com.example.sofka.domain.usecase;

import com.example.sofka.domain.Purchase;
import com.example.sofka.domain.gateways.PurchaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetAllRegisterUseCase {
    private final PurchaseRepository purchaseRepository;

    public List<Purchase> apply(){
        return this.purchaseRepository.findAllSales();
    }
}
