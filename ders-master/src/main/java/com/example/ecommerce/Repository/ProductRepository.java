package com.example.ecommerce.Repository;

import com.example.ecommerce.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product , Integer> {

    Optional<Product> getProductByProductName(String keyword);

    Optional<Product> findById(int id);

    List<Product> getProductByCode(String code);






}
