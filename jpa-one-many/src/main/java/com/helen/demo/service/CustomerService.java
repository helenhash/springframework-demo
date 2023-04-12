package com.helen.demo.service;

import com.helen.demo.entity.Customer;
import com.helen.demo.view.CustomerView;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();
    Customer getCustomerById(Integer customerId);
    Customer saveCustomer(CustomerView customerView);
}
