package com.culmanu.redis.repos;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import com.culmanu.redis.entities.Product;

@Repository
public class ProductCacheRepository {

    private final RedisTemplate<String, Product> redisTemplate;

    public ProductCacheRepository(RedisTemplate<String, Product> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void save(Product product) {
        redisTemplate.opsForValue().set("product:" + product.getId(), product);
    }

    public Product findById(Long id) {
        return redisTemplate.opsForValue().get("product:" + id);
    }

    public void deleteById(Long id) {
        redisTemplate.delete("product:" + id);
    }
}
