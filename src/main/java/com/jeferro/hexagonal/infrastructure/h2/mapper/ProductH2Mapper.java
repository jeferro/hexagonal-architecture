package com.jeferro.hexagonal.infrastructure.h2.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeferro.hexagonal.domain.models.Product;
import com.jeferro.hexagonal.infrastructure.h2.dtos.ProductEntityDTO;

public class ProductH2Mapper {

    @Autowired
    private ModelMapper mapper;

    public Product toDomain(ProductEntityDTO entity){
        return mapper.map(entity, Product.class);
    }
    
    public ProductEntityDTO toDTO(Product product){
        return mapper.map(product, ProductEntityDTO.class);
    }

}
