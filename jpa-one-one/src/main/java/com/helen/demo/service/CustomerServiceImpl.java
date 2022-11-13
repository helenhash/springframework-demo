package com.helen.demo.service;

import com.helen.demo.entity.Address;
import com.helen.demo.entity.Customer;
import com.helen.demo.repository.CustomerRepository;
import com.helen.demo.view.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return (List<Customer>) this.customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(CustomerRequest customerRequest) {
        Customer customer = new Customer();
        customer.setFirstname(customerRequest.getFirstname());
        customer.setLastname(customerRequest.getLastname());
        // ...

        Address address = new Address();
        address.setCity(customerRequest.getCity());
        address.setStreet(customerRequest.getStreet());
        address.setZipcode(customerRequest.getZipcode());

        // set address to customer and vice verse
        customer.setAddress(address);
        address.setCustomer(customer);

        return this.customerRepository.save(customer);
    }
}
