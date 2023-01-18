package com.example.sofka.infrastructure.adapters;

import com.example.sofka.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends MongoRepository<Product,String> {
}
