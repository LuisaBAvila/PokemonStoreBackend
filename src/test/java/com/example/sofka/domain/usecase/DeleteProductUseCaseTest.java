package com.example.sofka.domain.usecase;

import com.example.sofka.domain.Product;
import com.example.sofka.domain.gateways.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeleteProductUseCaseTest {
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private DeleteProductUseCase deleteProductUseCase;

    @Test
    public void deleteProduct(){
        Product product = new Product();
        product.setId("0256");

        lenient().when(productRepository.findProductById(product.getId()))
                .thenReturn(Optional.of(product));
        deleteProductUseCase.apply(product.getId());
        verify(productRepository).deleteProduct(product.getId());

    }


}