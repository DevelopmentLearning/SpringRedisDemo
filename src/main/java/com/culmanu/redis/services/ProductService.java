package com.culmanu.redis.services;

import com.culmanu.redis.entities.Product;
import com.culmanu.redis.repos.ProductCacheRepository;
import com.culmanu.redis.repos.ProductRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductCacheRepository productCacheRepository;

    public ProductService(ProductRepository productRepository, ProductCacheRepository productCacheRepository) {
        this.productRepository = productRepository;
        this.productCacheRepository = productCacheRepository;
    }

    // Write-aside: Save to DB and cache
    public Product saveProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        productCacheRepository.save(savedProduct);
        return savedProduct;
    }

    // Read-aside: Check cache first, then DB
    public Product getProductById(Long id) {
        Product cachedProduct = productCacheRepository.findById(id);
        if (cachedProduct != null) {
            return cachedProduct;
        }
        Product dbProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        productCacheRepository.save(dbProduct);
        return dbProduct;
    }

    public Product findProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // Invalidate cache on delete
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
        productCacheRepository.deleteById(id);
    }
}
