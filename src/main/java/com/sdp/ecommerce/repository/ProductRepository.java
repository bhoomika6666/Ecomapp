package com.sdp.ecommerce.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sdp.ecommerce.entity.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}
