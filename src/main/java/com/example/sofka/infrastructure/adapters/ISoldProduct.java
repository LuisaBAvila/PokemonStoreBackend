package com.example.sofka.infrastructure.adapters;

import com.example.sofka.domain.SoldProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ISoldProduct  extends MongoRepository<SoldProduct,String> {

}
