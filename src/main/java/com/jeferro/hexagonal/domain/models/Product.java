package com.jeferro.hexagonal.domain.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Long id;

    private String name;

    private String description;

}
