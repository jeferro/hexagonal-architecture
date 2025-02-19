package com.jeferro.hexagonal.application;

import com.jeferro.hexagonal.domain.exceptions.ProductNotFoundException;
import com.jeferro.hexagonal.domain.models.Product;
import com.jeferro.hexagonal.domain.repositories.ProductRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetProductUseCaseImpl implements GetProductUseCase{

    private final ProductRepository productRepository;
    
    @Override
    public Product execute(Long id) {
        return productRepository.findById(id)
                                .orElseThrow(() -> new ProductNotFoundException("Product not found: " + id));
    }
    
}
