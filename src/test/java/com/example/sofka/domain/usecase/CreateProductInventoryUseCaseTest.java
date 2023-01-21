package com.example.sofka.domain.usecase;

import com.example.sofka.api.dtos.ProductDTO;
import com.example.sofka.domain.Product;
import com.example.sofka.domain.gateways.ProductRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;




import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class CreateProductInventoryUseCaseTest {

    @InjectMocks
    private CreateProductInventoryUseCase useCase;
    @Mock
    private ProductRepository productRepository;

    @Test
    void apply() {

        var product = new Product("115e","banana",50,
                true,1,20);

        lenient().when(productRepository.createProductInventory(any())).thenReturn(product);
       var productSave= useCase.apply(new ProductDTO("115e","banana",50,
                true,1,20));

        Assertions.assertEquals(product,productSave);


    }

}