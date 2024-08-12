package com.helen.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Date;

@Getter
@Setter
@Table(name = "`Order`")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "order_date")
    private Date orderDate;
    @Column
    private Double price;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false, insertable = false, updatable = false)
    private Customer customer;

}
