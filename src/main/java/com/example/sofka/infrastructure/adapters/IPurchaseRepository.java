package com.example.sofka.infrastructure.adapters;

import com.example.sofka.domain.Purchase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPurchaseRepository extends MongoRepository<Purchase,String> {
}
