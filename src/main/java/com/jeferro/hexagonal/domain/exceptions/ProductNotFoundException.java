package com.jeferro.hexagonal.domain.exceptions;

public class ProductNotFoundException extends RuntimeException{
    
    public ProductNotFoundException(String msg){
        super(msg);
    }
}
