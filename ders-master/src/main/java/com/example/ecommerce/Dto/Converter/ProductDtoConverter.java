package com.example.ecommerce.Dto.Converter;

import com.example.ecommerce.Dto.ProductDto;
import com.example.ecommerce.Model.Product;
import org.springframework.stereotype.Component;

@Component //APPLİCATİON CONTEXT
public class ProductDtoConverter {

    public ProductDto convertToProduct(Product product){
        return new ProductDto(
                product.getId(),
                product.getCode(),
                product.getProductName(),
                product.getProductImage(),
                product.getProductPrice(),
                product.getCreatedAt(),
                product.getUpdateAt()
        );
    }
}
