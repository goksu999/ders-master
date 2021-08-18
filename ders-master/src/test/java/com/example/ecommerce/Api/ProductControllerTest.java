package com.example.ecommerce.Api;

import com.example.ecommerce.Model.Product;
import com.example.ecommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductControllerTest {

    private final ProductRepository productRepository;

    @Autowired
    public ProductControllerTest(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProductData() {
        Product product = new Product(1,"deneme","telefon",null,null,null,null);

        Product savedProduct = productRepository.save(product);


    }
}