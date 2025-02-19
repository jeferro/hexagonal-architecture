package com.jeferro.hexagonal.infrastructure.rest;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeferro.hexagonal.application.CreateProductUseCase;
import com.jeferro.hexagonal.application.GetProductUseCase;
import com.jeferro.hexagonal.infrastructure.rest.dtos.CreateProductRestDTO;
import com.jeferro.hexagonal.infrastructure.rest.dtos.ProductRestDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class ProductRestController {
    
    private final CreateProductUseCase createProductUseCase;

    private final GetProductUseCase getProductUseCase;

    private final ModelMapper mapper;

    @PostMapping("/products")
    public ProductRestDTO createProduct(@RequestBody CreateProductRestDTO createProductRestDTO){
        var product = createProductUseCase.execute(createProductRestDTO.getId(),
                createProductRestDTO.getName(),
                createProductRestDTO.getDescription());

        return mapper.map(product, ProductRestDTO.class);
    }

    @GetMapping("/products/{id}")
    public ProductRestDTO getProduct(@PathVariable Long id){
        var product = getProductUseCase.execute(id);

        return mapper.map(product, ProductRestDTO.class);
    }
    
}
