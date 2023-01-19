package com.example.sofka.domain;

import com.example.sofka.api.dtos.SoldProductDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(value = "SoldProduct")
public class SoldProduct {
    private String idProduct;
    private Integer quantity;
    private String idUser;


    public SoldProduct(String idProduct, Integer quantity, String idUser) {
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.idUser = idUser;
    }
}
