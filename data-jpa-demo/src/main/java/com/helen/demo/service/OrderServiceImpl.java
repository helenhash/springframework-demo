package com.helen.demo.service;

import com.helen.demo.entity.Order;
import com.helen.demo.repository.OrderRepository;
import com.helen.demo.view.OrderView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    public List<OrderView> getOrdersByCustomer(Integer customerId) {
        List<Order> orders = this.orderRepository.findByCustomerId(customerId);
        //convert orders entity to order view (json)
        List<OrderView> orderViews = orders.stream()
                .map(OrderView::of)
                .collect(Collectors.toList());
        return orderViews;
    }
}
