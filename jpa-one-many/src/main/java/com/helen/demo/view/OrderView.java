package com.helen.demo.view;

import com.helen.demo.entity.Order;

import java.util.Date;

public class OrderView {

    private Integer orderId;
    private Integer customerId;
    private Date orderDate;
    private Double price;
    private CustomerView customer;

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

    public CustomerView getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerView customer) {
        this.customer = customer;
    }

    public static OrderView of(Order entity){
        OrderView orderView = new OrderView();
        orderView.setOrderId(entity.getOrderId());
        orderView.setCustomerId(entity.getCustomerId());
        orderView.setOrderDate(entity.getOrderDate());
        orderView.setPrice(entity.getPrice());
        orderView.setCustomer(CustomerView.of(entity.getCustomer()));
        return orderView;
    }
}
