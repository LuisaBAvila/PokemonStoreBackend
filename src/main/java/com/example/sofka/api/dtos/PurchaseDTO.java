package com.example.sofka.api.dtos;


import com.example.sofka.domain.Product;
import com.example.sofka.domain.SoldProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
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

    @NotBlank(message = "The product name cannot be empty")
    protected String idType;

    @NotBlank(message = "The product name cannot be empty")
    protected String idClient;
    @NotBlank(message = "The product name cannot be empty")
    protected String clientName;

}
