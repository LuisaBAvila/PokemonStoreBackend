package com.example.sofka.domain.usecase;

import com.example.sofka.domain.Product;
import com.example.sofka.domain.gateways.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class FindAllProductsUseCaseTest {
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private FindAllProductsUseCase findAllProductsUseCase;

    @Test
    public void getAllProducts(){
        List<Product> products = new ArrayList<>();
        products.add(new Product());

        BDDMockito.given(productRepository.findAllProductsInventory()).willReturn(products);

        List<Product> expect = findAllProductsUseCase.apply();
        Assertions.assertEquals(expect,products);
        verify(productRepository).findAllProductsInventory();
    }

}