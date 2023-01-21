package com.example.sofka.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SoldProductDTO {
    protected Integer quantity;
    @NotBlank(message = "The product name cannot be empty")
    protected String idClient;

}
