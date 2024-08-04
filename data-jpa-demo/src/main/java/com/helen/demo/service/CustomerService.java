package com.helen.demo.service;

import com.helen.demo.dto.CustomerDto;
import com.helen.demo.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();
    Customer getCustomerById(Integer customerId);
    Customer saveCustomer(CustomerDto customerDto);
}
