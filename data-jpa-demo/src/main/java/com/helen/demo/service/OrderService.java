package com.helen.demo.service;

import com.helen.demo.entity.Order;
import com.helen.demo.view.OrderView;

import java.util.List;

public interface OrderService {

    List<OrderView> getOrdersByCustomer(Integer customerId);
}
