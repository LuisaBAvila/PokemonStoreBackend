package com.example.sofka.api.dtos;


import com.example.sofka.domain.Product;
import com.example.sofka.domain.SoldProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.Instant;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDTO {
    @Id
    protected String idSale;
    protected Instant date = Instant.now();
    protected String idType;
    protected String idClient;
    protected String clientName;

}
