package com.culmanu.redis.repos;


import com.culmanu.redis.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT DISTINCT c FROM Customer c JOIN FETCH c.orders")
    List<Customer> findAllCustomersWithOrders();

    @Query("SELECT DISTINCT c FROM Customer c JOIN FETCH c.orders WHERE c.id = :id")
    Optional<Customer> findCustomerWithOrdersById(@Param("id") Long id);
}