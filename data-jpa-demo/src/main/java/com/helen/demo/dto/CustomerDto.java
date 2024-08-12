package com.helen.demo.dto;

import com.helen.demo.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

//object to request for saving.

@Getter
@Setter
public class CustomerDto {

    private Integer id;
    private String firstname;
    private String lastname;
    private Boolean gender;
    private Date birthday;

    private Integer customerId;
    private String city;
    private String zipcode;
    private String street;

    public static CustomerDto of(Customer entity){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setFirstname(entity.getFirstname());
        customerDto.setCity(entity.getAddress() == null ? null : entity.getAddress().getCity());
        return customerDto;
    }
}
