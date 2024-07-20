package com.helen.demo.service;

import com.helen.demo.dto.OrderDto;

import java.util.List;

public interface OrderService {

    List<OrderDto> getOrdersByCustomer(Integer customerId);
}
