package com.example.sofka.domain.gateways;

import com.example.sofka.domain.Product;
import com.example.sofka.domain.SoldProduct;

import java.util.List;

public interface SoldProdcutRespository {
    SoldProduct createSoldProduct(SoldProduct soldProduct);
    List<SoldProduct> findAllSoldProducts();
}
