package com.example.sofka.infrastructure.postgres;

import com.example.sofka.domain.SoldProduct;
import com.example.sofka.domain.gateways.SoldProdcutRespository;
import com.example.sofka.infrastructure.adapters.ISoldProduct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class SoldProdcutRepositoryAdapater implements SoldProdcutRespository {
    private final ISoldProduct iSoldProduct;


    @Override
    public SoldProduct createSoldProduct(SoldProduct soldProduct) {
        return this.iSoldProduct.save(soldProduct);
    }

    @Override
    public List<SoldProduct> findAllSoldProducts() {
        return iSoldProduct.findAll();
    }
}
