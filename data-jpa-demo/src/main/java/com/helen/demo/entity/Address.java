package com.helen.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
public class Address {
    @Id
    @Column(name = "customer_id")
    private Integer customerId;
    @Column
    private String city;
    @Column
    private String zipcode;
    @Column
    private String street;

    @JsonIgnore
    @OneToOne
    @MapsId
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
