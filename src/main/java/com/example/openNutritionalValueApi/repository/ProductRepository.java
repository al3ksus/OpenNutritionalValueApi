package com.example.openNutritionalValueApi.repository;

import com.example.openNutritionalValueApi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByTitle(String title);
}
