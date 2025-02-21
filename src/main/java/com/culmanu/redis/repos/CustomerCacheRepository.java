package com.culmanu.redis.repos;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import com.culmanu.redis.entities.Customer;

@Repository
public class CustomerCacheRepository {

    private final RedisTemplate<String, Customer> redisTemplate;

    public CustomerCacheRepository(RedisTemplate<String, Customer> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void save(Customer customer) {
        redisTemplate.opsForValue().set("customer:" + customer.getId(), customer);
    }

    public Customer findById(Long id) {
        return redisTemplate.opsForValue().get("customer:" + id);
    }

    public void deleteById(Long id) {
        redisTemplate.delete("customer:" + id);
    }
}
