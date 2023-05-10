package com.simpel.restapi.simpelrestapi.repository;

import com.simpel.restapi.simpelrestapi.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface ProductRepo extends CrudRepository<Product, Integer> {
    Optional<Product> findByProductCode(String productCode);
    void deleteByProductCode(String productCode);

}
