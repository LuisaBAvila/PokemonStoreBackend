package com.example.sofka.domain.usecase;

import com.example.sofka.api.dtos.SoldProductDTO;
import com.example.sofka.domain.Product;
import com.example.sofka.domain.SoldProduct;
import com.example.sofka.domain.gateways.ProductRepository;
import com.example.sofka.domain.gateways.SoldProdcutRespository;
import com.example.sofka.infrastructure.utils.MismatchDataException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateSoldProductUseCase {
    private final SoldProdcutRespository soldProdcutRespository;
    private final FindProductByIdUseCase findProductByIdUseCase;
    private ProductRepository productRepository;


    public SoldProduct apply(String id, SoldProductDTO soldProductDTO){
        Product product = this.findProductByIdUseCase.apply(id);
        checkInventory(product.getInventory());
        checkminProducts(product.getMinProducts(),soldProductDTO.getQuantity());
        checkmaxProducts(product.getMaxProducts(), soldProductDTO.getQuantity());

        Integer inventory = product.getInventory() - soldProductDTO.getQuantity();

        Product newProdcut = new Product(product.getId(), product.getName(),
                inventory,product.getEnabled(),
                product.getMinProducts(), product.getMaxProducts());

        this.productRepository.updateProduct(product.getId(),newProdcut);

        SoldProduct soldProduct = new SoldProduct(product.getId(),soldProductDTO.getQuantity(),soldProductDTO.getIdClient());
        return this.soldProdcutRespository.createSoldProduct(soldProduct);
    }
    private void checkInventory(Integer inventory) {
        if (inventory <=0) {
            throw new MismatchDataException("El producto no se encuentra disponible");
        }
    }
    private void checkminProducts(Integer minProducts, Integer selectedProducts) {
        if (selectedProducts < minProducts ) {
            throw new MismatchDataException("No cumple con la cantidad mínima de productos");
        }
    }

    private void checkmaxProducts(Integer maxProducts, Integer selectedProducts) {
        if (selectedProducts > maxProducts ) {
            throw new MismatchDataException("No cumple con la cantidad maxima de productos");
        }
    }

}
