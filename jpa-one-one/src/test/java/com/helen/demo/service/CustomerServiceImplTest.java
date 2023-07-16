package com.helen.demo.service;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.helen.demo.entity.Address;
import com.helen.demo.entity.Customer;
import com.helen.demo.repository.CustomerRepository;
import com.helen.demo.view.CustomerRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CustomerServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CustomerServiceImplTest {
    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    /**
     * Method under test: {@link CustomerServiceImpl#getAllCustomers()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllCustomers() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.helen.demo.service.CustomerServiceImpl.getAllCustomers(CustomerServiceImpl.java:30)
        //   In order to prevent getAllCustomers()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAllCustomers().
        //   See https://diff.blue/R013 to resolve this issue.

        (new CustomerServiceImpl()).getAllCustomers();
    }

    /**
     * Method under test: {@link CustomerServiceImpl#getCustomerById(Integer)}
     */
    @Test
    void testGetCustomerById() {
        Address address = new Address();
        address.setCity("Oxford");
        address.setCustomer(new Customer());
        address.setCustomerId(123);
        address.setStreet("Street");
        address.setZipcode("21654");

        Customer customer = new Customer();
        customer.setAddress(address);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        customer.setBirthday(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        customer.setFirstname("Jane");
        customer.setGender(true);
        customer.setId(1);
        customer.setLastname("Doe");

        Address address1 = new Address();
        address1.setCity("Oxford");
        address1.setCustomer(customer);
        address1.setCustomerId(123);
        address1.setStreet("Street");
        address1.setZipcode("21654");

        Customer customer1 = new Customer();
        customer1.setAddress(address1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        customer1.setBirthday(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        customer1.setFirstname("Jane");
        customer1.setGender(true);
        customer1.setId(1);
        customer1.setLastname("Doe");
        Optional<Customer> ofResult = Optional.of(customer1);
        when(this.customerRepository.findById((Integer) any())).thenReturn(ofResult);
        assertSame(customer1, this.customerServiceImpl.getCustomerById(123));
        verify(this.customerRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link CustomerServiceImpl#getCustomerById(Integer)}
     */
    @Test
    void testGetCustomerById2() {
        when(this.customerRepository.findById((Integer) any())).thenReturn(Optional.empty());
        assertNull(this.customerServiceImpl.getCustomerById(123));
        verify(this.customerRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link CustomerServiceImpl#saveCustomer(CustomerRequest)}
     */
    @Test
    void testSaveCustomer() {
        Customer customer = new Customer();
        customer.setAddress(new Address());
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        customer.setBirthday(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        customer.setFirstname("Jane");
        customer.setGender(true);
        customer.setId(1);
        customer.setLastname("Doe");

        Address address = new Address();
        address.setCity("Oxford");
        address.setCustomer(customer);
        address.setCustomerId(123);
        address.setStreet("Street");
        address.setZipcode("21654");

        Customer customer1 = new Customer();
        customer1.setAddress(address);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        customer1.setBirthday(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        customer1.setFirstname("Jane");
        customer1.setGender(true);
        customer1.setId(1);
        customer1.setLastname("Doe");

        Address address1 = new Address();
        address1.setCity("Oxford");
        address1.setCustomer(customer1);
        address1.setCustomerId(123);
        address1.setStreet("Street");
        address1.setZipcode("21654");

        Customer customer2 = new Customer();
        customer2.setAddress(address1);
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        customer2.setBirthday(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        customer2.setFirstname("Jane");
        customer2.setGender(true);
        customer2.setId(1);
        customer2.setLastname("Doe");
        when(this.customerRepository.save((Customer) any())).thenReturn(customer2);

        CustomerRequest customerRequest = new CustomerRequest();
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        customerRequest.setBirthday(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        customerRequest.setCity("Oxford");
        customerRequest.setCustomerId(123);
        customerRequest.setFirstname("Jane");
        customerRequest.setGender(true);
        customerRequest.setId(1);
        customerRequest.setLastname("Doe");
        customerRequest.setStreet("Street");
        customerRequest.setZipcode("21654");
        assertSame(customer2, this.customerServiceImpl.saveCustomer(customerRequest));
        verify(this.customerRepository).save((Customer) any());
    }
}

