package com.example.sofka.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "Inventory")
@Getter
@Setter
public class Product {
    @Id
    private String id;
    private String name;
    private Integer inventory;
    private Boolean enabled;
    private Integer minProducts;
    private Integer maxProducts;

    public Product(String id, String name, Integer inventory, Boolean enabled, Integer minProducts, Integer maxProducts) {
        this.id = id;
        this.name = name;
        this.inventory = inventory;
        this.enabled = enabled;
        this.minProducts = minProducts;
        this.maxProducts = maxProducts;
    }

    public Product() {
    }
}
