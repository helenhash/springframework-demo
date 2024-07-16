package com.helen.demo.service;

import com.helen.demo.entity.Address;
import com.helen.demo.entity.Customer;
import com.helen.demo.repository.CustomerRepository;
import com.helen.demo.view.CustomerView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private static final Logger LOGGER  = LoggerFactory.getLogger(CustomerServiceImpl.class);
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        LOGGER.trace("TRACE Log from service");
        LOGGER.debug("DEBUG Log from service");
        LOGGER.info("An INFO Log from service");
        LOGGER.warn("A WARN Log from service");
        LOGGER.error("An ERROR Log from service");
        return (List<Customer>) this.customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Integer customerId) {
        Optional<Customer> optional = this.customerRepository.findById(customerId);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Override
    public Customer saveCustomer(CustomerView customerView) {
        Customer customer = new Customer();
//        customer.setFirstname(customerRequest.getFirstname());
        customer.setLastname(customerView.getLastname());
        // ...

        Address address = new Address();
        address.setCity(customerView.getCity());
        address.setStreet(customerView.getStreet());
        address.setZipcode(customerView.getZipcode());

        // set address to customer and vice verse
        customer.setAddress(address);
        address.setCustomer(customer);

        return this.customerRepository.save(customer);
    }
}
