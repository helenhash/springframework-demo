package com.helen.demo.controller;

import com.helen.demo.entity.Order;
import com.helen.demo.service.OrderService;
import com.helen.demo.view.OrderView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{customerId}")
    public ResponseEntity<List<OrderView>> getOrdersByCustomer(@PathVariable Integer customerId){
        return ResponseEntity.ok(this.orderService.getOrdersByCustomer(customerId));
    }
}
