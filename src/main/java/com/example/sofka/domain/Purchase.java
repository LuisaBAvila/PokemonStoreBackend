package com.example.sofka.domain;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Set;

@Document(value = "SalesCart")
@Getter
@Setter
public class Purchase {
    @Id
    private String idSale;
    private Instant date = Instant.now();
    private String idType;
    private String idClient;
    private String clientName;
    private Set<Product> products;

    public Purchase(String idSale, Instant date, String idType, String idClient, String clientName, Set<Product> products) {
        this.idSale = idSale;
        this.date = date;
        this.idType = idType;
        this.idClient = idClient;
        this.clientName = clientName;
        this.products = products;
    }
}
