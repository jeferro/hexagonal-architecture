package com.jeferro.hexagonal.infrastructure.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeferro.hexagonal.infrastructure.h2.dtos.ProductEntityDTO;

public interface ProductJpaRepository extends JpaRepository<ProductEntityDTO, Long>{
    
}
