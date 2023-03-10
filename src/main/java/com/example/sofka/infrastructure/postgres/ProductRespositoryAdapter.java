package com.example.sofka.infrastructure.postgres;

import com.example.sofka.domain.Product;
import com.example.sofka.domain.gateways.ProductRepository;
import com.example.sofka.infrastructure.adapters.IProductRepository;
import com.example.sofka.infrastructure.utils.MismatchDataException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class ProductRespositoryAdapter implements ProductRepository {
    private final IProductRepository iProductRepository;
    private final ModelMapper modelMapper;



    @Override
    public Product createProductInventory(Product product) {
        return this.iProductRepository.save(product);
    }

    @Override
    public List<Product> findAllProductsInventory() {
        return iProductRepository.findAll();
    }

    @Override
    public Optional<Product> findProductById(String id) {
        return this.iProductRepository.findById(id);
    }

    @Override
    public Product updateProduct(String id, Product product) {
        checkId(id);
        var previusProduct = this.iProductRepository.findById(id).orElse(null);
        if(previusProduct != null) {
           modelMapper.map(product,previusProduct);
           return iProductRepository.save(previusProduct);
        }
        return null;
    }


    @Override
    public void deleteProduct(String id) {
        checkId(id);
       this.iProductRepository.deleteById(id);
    }

    private void checkId(String id) {
        if (!iProductRepository.existsById(id)) {
            throw new MismatchDataException("El producto con el id seleccionado no existe" + id);
        }
    }
}
