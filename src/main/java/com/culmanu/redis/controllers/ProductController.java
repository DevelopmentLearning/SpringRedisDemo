package com.culmanu.redis.controllers;

import com.culmanu.redis.services.ProductService;
import org.springframework.web.bind.annotation.*;
import com.culmanu.redis.entities.Product;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProductWithCache(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/nocache/{id}")
    public Product getProductWithoutCache(@PathVariable Long id) {
        return productService.findProductById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}