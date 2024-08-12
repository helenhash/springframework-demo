package com.helen.demo.service.impl;

import com.helen.demo.dto.CustomerDto;
import com.helen.demo.entity.Address;
import com.helen.demo.entity.Customer;
import com.helen.demo.repository.CustomerRepository;
import com.helen.demo.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private static final Logger LOGGER  = LoggerFactory.getLogger(CustomerServiceImpl.class);
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        this.customerRepository.getAllCustomer();
//        this.customerRepository.findByFirstname("Giau 1");
        return (List<Customer>) this.customerRepository.findAll();

    }

    @Override
    public Customer getCustomerById(Integer customerId) {
        Optional<Customer> optional = this.customerRepository.findById(customerId);
        return optional.orElse(null);
    }

    @Transactional
    @Override
    public Customer saveCustomer(CustomerDto customerDto) {

        Customer customer = new Customer();
        customer.setFirstname(customerDto.getFirstname());
        customer.setLastname(customerDto.getLastname());

        Address address = new Address();
        address.setCity(customerDto.getCity());
        address.setStreet(customerDto.getStreet());
        address.setZipcode(customerDto.getZipcode());

        // set address to customer and vice verse
        customer.setAddress(address);//
        address.setCustomer(customer);

        this.customerRepository.save(customer);
        //get saved customer
        this.customerRepository.findByFirstname(customer.getFirstname());


        return this.customerRepository.save(customer);
    }
}
