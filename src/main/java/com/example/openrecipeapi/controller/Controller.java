package com.example.openrecipeapi.controller;

import com.example.openrecipeapi.exception.ProductNotFoundException;
import com.example.openrecipeapi.model.Product;
import com.example.openrecipeapi.service.ProductService;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("open_recipe_api")
public class Controller {

    private final ProductService productService;

    @GetMapping("/products")
    public List<Product> getList() {
        return productService.getList();
    }

    @PostMapping("/products/add")
    @ResponseStatus(HttpStatus.OK)
    public void add(@RequestBody  Product product) {
        System.out.println(product.getTitle());
        productService.add(product);
    }

    @GetMapping("/products/{id}")
    public Object getById(@PathVariable long id) {
        Optional<Product> product = productService.findById(id);

        if (product.isPresent()) {
            return product.get();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with this id does not exist");
        }
    }

    @GetMapping("/products/get")
    public Object getByTitle(@RequestParam("product") String title) {
        Optional<Product> product = productService.findByTitle(title);

        if (product.isPresent()) {
            return product.get();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This product does not exist");
        }
    }
}
