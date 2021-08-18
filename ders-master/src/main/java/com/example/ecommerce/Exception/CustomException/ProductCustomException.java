package com.example.ecommerce.Exception.CustomException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductCustomException  extends RuntimeException{
    public ProductCustomException(String message) {
        super(message);
    }
}
