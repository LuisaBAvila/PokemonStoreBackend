package com.example.sofka.domain.usecase;

import com.example.sofka.api.dtos.ProductDTO;
import com.example.sofka.domain.Product;
import com.example.sofka.domain.gateways.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UpdateProductUseCaseTest {
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private CreateProductInventoryUseCase createProductInventoryUseCase;
    @BeforeEach
    void setUp(){

    }


    @Test
    public void updateProducts(){
        Product product = new Product("115e","banana",50,
                true,1,20);


        ProductDTO productUpdate = new ProductDTO("115e","Grapes",50,
                true,1,20);



        lenient().when(productRepository.findProductById(product.getId())).thenReturn(Optional.of(product));
        lenient().when(productRepository.createProductInventory(product)).thenReturn(product);
        createProductInventoryUseCase.apply(productUpdate);

       verify(productRepository).findProductById(product.getId());




    }


}