package com.jeferro.hexagonal.application;

import com.jeferro.hexagonal.domain.models.Product;

public interface CreateProductUseCase {
   
    Product execute(Long id, String name, String description);
    
}
