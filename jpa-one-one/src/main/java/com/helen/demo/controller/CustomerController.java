package com.helen.demo.controller;

import com.helen.demo.entity.Customer;
import com.helen.demo.service.CustomerService;
import com.helen.demo.view.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers(){
        return ResponseEntity.ok(this.customerService.getAllCustomers());
    }

    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody CustomerRequest customerRequest){
        return ResponseEntity.ok(this.customerService.saveCustomer(customerRequest));
    }
}
