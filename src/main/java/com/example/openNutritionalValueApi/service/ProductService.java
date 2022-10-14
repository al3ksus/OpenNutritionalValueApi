package com.example.openNutritionalValueApi.service;

import com.example.openNutritionalValueApi.model.Product;
import com.example.openNutritionalValueApi.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getList() {
        return productRepository.findAll();
    }

    public void add(Product product) {
        productRepository.save(product);
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Optional<Product> findByTitle(String title) {
        return productRepository.findByTitle(title);
    }
}
