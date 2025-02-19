package com.jeferro.hexagonal.domain.repositories;

import java.util.Optional;

import com.jeferro.hexagonal.domain.models.Product;

public interface ProductRepository {
    
    Product save(Product product);
    
    Optional<Product> findById(Long id);
    
}
