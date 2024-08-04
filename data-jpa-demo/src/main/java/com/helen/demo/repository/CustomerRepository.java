package com.helen.demo.repository;

import com.helen.demo.entity.Customer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT c FROM Customer c JOIN FETCH c.address JOIN FETCH c.orders")
    List<Customer> getAllCustomer();

    @EntityGraph(attributePaths = {"orders", "address"})
    Customer findByFirstname(String fname);
}
