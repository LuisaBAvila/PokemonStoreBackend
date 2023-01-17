package com.example.sofka.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    protected String id;
    @NotBlank(message = "The product name cannot be empty")
    protected String name;
    @NotBlank(message = "The quantify of the product cannot be empty")
    protected Integer inventory;
    @NotBlank(message = "Must indicate if the product is enable")
    protected Boolean enabled;
    @NotBlank(message = "Must indicate the maximum quantity of the product")
    protected Integer minProducts;
    @NotBlank(message = "Must indicate the minimum quantity of the product")
    protected Integer maxProducts;


}

