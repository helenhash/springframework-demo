package com.helen.demo.entity;

import jakarta.persistence.*;
import jakarta.persistence.NamedEntityGraph;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@NamedEntityGraph(name = "Customer.orders",
        attributeNodes = @NamedAttributeNode("orders")
)
public class Customer {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column(name = "gender")
    private Boolean gender;
    @Column(name = "date_of_birth")
    private Date birthday;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<Order> orders;

}
