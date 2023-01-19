package com.example.sofka.domain.usecase;


import com.example.sofka.domain.Product;
import com.example.sofka.domain.SoldProduct;
import com.example.sofka.domain.gateways.SoldProdcutRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetAllSoldProductsUseCase {
    private final SoldProdcutRespository soldProdcutRespository;
    public List<SoldProduct> apply(){
        return this.soldProdcutRespository.findAllSoldProducts();
    }
}
