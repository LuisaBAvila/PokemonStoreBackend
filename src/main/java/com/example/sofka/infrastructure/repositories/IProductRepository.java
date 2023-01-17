package com.example.sofka.infrastructure.repositories;

import com.example.sofka.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IProductRepository extends MongoRepository<Product,String> {
}
