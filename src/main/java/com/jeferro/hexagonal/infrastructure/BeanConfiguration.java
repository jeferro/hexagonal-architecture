package com.jeferro.hexagonal.infrastructure;

import com.jeferro.hexagonal.application.CreateProductUseCase;
import com.jeferro.hexagonal.application.CreateProductUseCaseImpl;
import com.jeferro.hexagonal.application.GetProductUseCase;
import com.jeferro.hexagonal.application.GetProductUseCaseImpl;
import com.jeferro.hexagonal.domain.repositories.ProductRepository;
import com.jeferro.hexagonal.infrastructure.h2.ProductH2Repository;
import com.jeferro.hexagonal.infrastructure.h2.mapper.ProductH2Mapper;
import com.jeferro.hexagonal.infrastructure.h2.repository.ProductJpaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public ProductH2Mapper productMapper(){
        return new ProductH2Mapper();
    }
    
    @Bean
    public ProductH2Repository productH2Repository(ProductJpaRepository productJpaRepository, ProductH2Mapper productH2Mapper) {
        return new ProductH2Repository(productJpaRepository, productH2Mapper);
    }

    @Bean
    public CreateProductUseCase createProductUseCase(ProductRepository productRepository) {
        return new CreateProductUseCaseImpl(productRepository);
    }

    @Bean
    public GetProductUseCase getProductUseCase(ProductRepository productRepository) {
        return new GetProductUseCaseImpl(productRepository);
    }

}
