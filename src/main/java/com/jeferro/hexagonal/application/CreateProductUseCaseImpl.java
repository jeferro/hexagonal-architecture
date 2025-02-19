package com.jeferro.hexagonal.application;

import com.jeferro.hexagonal.domain.models.Product;
import com.jeferro.hexagonal.domain.repositories.ProductRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateProductUseCaseImpl implements CreateProductUseCase{

    private final ProductRepository productRepository;

    @Override
    public Product execute(Long id, String name, String description) {
        var product = new Product(id, name, description);

        return productRepository.save(product);
    }
    
}
