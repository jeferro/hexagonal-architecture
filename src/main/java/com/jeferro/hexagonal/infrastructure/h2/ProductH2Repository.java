package com.jeferro.hexagonal.infrastructure.h2;

import com.jeferro.hexagonal.domain.models.Product;
import com.jeferro.hexagonal.domain.repositories.ProductRepository;
import com.jeferro.hexagonal.infrastructure.h2.dtos.ProductEntityDTO;
import com.jeferro.hexagonal.infrastructure.h2.mapper.ProductH2Mapper;
import com.jeferro.hexagonal.infrastructure.h2.repository.ProductJpaRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class ProductH2Repository implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;

    private final ProductH2Mapper productH2Mapper;

    @Override
    public Product save(Product product) {
        ProductEntityDTO productEntityDTO = productH2Mapper.toDTO(product);

        productJpaRepository.save(productEntityDTO);

        return productH2Mapper.toDomain(productEntityDTO);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productJpaRepository.findById(id)
                .map(productH2Mapper::toDomain);
    }

}
