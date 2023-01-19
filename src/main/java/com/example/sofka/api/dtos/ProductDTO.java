package com.example.sofka.api.dtos;

import com.example.sofka.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    @Id
    protected String id;
    @Size(min=1, message= "whatever")
    @NotBlank(message = "The product name cannot be empty")
    protected String name;

    protected Integer inventory;

    protected Boolean enabled;

    protected Integer minProducts;


    protected Integer maxProducts;



}

