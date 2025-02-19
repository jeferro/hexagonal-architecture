package com.jeferro.hexagonal.infrastructure.rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRestDTO {
    
    private Long id;

    private String name;

    private String description;
}
