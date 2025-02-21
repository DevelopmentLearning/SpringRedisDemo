package com.culmanu.redis.controllers;

import com.culmanu.redis.entities.Customer;
import com.culmanu.redis.services.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(final CustomerService customerService) {
        this.customerService = customerService;
    }

    // Fetch a single customer by ID with their orders
    @GetMapping("/{id}")
    public Customer getCustomerWithOrdersById(@PathVariable Long id) {
        return customerService.getCustomerWithOrdersById(id);
    }

    @GetMapping("/nocache/{id}")
    public Customer getCustomerWithOrdersByIdNoCache(@PathVariable Long id) {
        return customerService.getCustomerWithOrdersByIdNoCache(id);
    }


}
