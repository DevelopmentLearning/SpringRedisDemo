package com.culmanu.redis.services;

import com.culmanu.redis.entities.Customer;
import com.culmanu.redis.repos.CustomerCacheRepository;
import com.culmanu.redis.repos.CustomerRepository;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerCacheRepository customerCacheRepository;

    public CustomerService(final CustomerRepository customerRepository, final CustomerCacheRepository customerCacheRepository) {
        this.customerRepository = customerRepository;
        this.customerCacheRepository = customerCacheRepository;
    }

    // Fetch a single customer by ID with their orders
    public Customer getCustomerWithOrdersById(Long id) {
        System.out.println("With cache");
        // Check cache first
        Customer cachedCustomer = customerCacheRepository.findById(id);
        if (cachedCustomer != null) {
            return cachedCustomer;
        }

        // Fetch from database if not in cache
        Customer dbCustomer = customerRepository.findCustomerWithOrdersById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        // Save to cache
        customerCacheRepository.save(dbCustomer);
        return dbCustomer;
    }


    public Customer getCustomerWithOrdersByIdNoCache(Long id) {
        // Fetch from database if not in cache
        System.out.println("No cache");
        Customer dbCustomer = customerRepository.findCustomerWithOrdersById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        // Save to cache
        customerCacheRepository.save(dbCustomer);
        return dbCustomer;
    }


}
