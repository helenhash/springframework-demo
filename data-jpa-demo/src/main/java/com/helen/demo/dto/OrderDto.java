package com.helen.demo.dto;

import com.helen.demo.entity.Order;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class OrderDto {

    private Integer orderId;
    private Integer customerId;
    private Date orderDate;
    private Double price;
    private CustomerDto customer;

    public static OrderDto of(Order entity){
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId(entity.getOrderId());
        orderDto.setCustomerId(entity.getCustomerId());
        orderDto.setOrderDate(entity.getOrderDate());
        orderDto.setPrice(entity.getPrice());
        orderDto.setCustomer(CustomerDto.of(entity.getCustomer()));
        return orderDto;
    }
}
