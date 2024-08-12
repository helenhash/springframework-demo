package com.helen.demo.service.impl;

import com.helen.demo.dto.OrderDto;
import com.helen.demo.entity.Order;
import com.helen.demo.repository.OrderRepository;
import com.helen.demo.service.OrderService;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    @Override
    public List<OrderDto> getOrdersByCustomer(Integer customerId) {
        List<Order> orders = this.orderRepository.findByCustomerId(customerId);
        //convert orders entity to order view (json)
        List<OrderDto> orderDtos = orders.stream()
                .map(OrderDto::of)
                .collect(Collectors.toList());
        return orderDtos;
    }
}
