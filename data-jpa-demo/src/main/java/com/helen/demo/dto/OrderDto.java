package com.helen.demo.dto;

import com.helen.demo.entity.Order;

import java.util.Date;

public class OrderDto {

    private Integer orderId;
    private Integer customerId;
    private Date orderDate;
    private Double price;
    private CustomerDto customer;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

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
