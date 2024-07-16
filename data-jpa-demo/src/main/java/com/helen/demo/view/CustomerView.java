package com.helen.demo.view;

import com.helen.demo.entity.Customer;

import java.util.Date;

//object to request for saving.

public class CustomerView {

    private Integer id;
    private String firstname;
    private String lastname;
    private Boolean gender;
    private Date birthday;

    private Integer customerId;
    private String city;
    private String zipcode;
    private String street;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public static CustomerView of(Customer entity){
        CustomerView customerView = new CustomerView();
        customerView.setFirstname(entity.getFirstname());
        customerView.setCity(entity.getAddress() == null ? null : entity.getAddress().getCity());
        return customerView;
    }
}
