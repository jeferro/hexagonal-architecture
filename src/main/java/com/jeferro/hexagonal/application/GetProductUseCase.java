package com.jeferro.hexagonal.application;

import com.jeferro.hexagonal.domain.models.Product;

public interface GetProductUseCase {
   
    Product execute(Long id);
    
}
