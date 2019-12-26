package com.course.msscbrewbery.services;

import com.course.msscbrewbery.web.model.CustomerDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface CustomerService {
    void deleteCustomer(UUID uuid);

    CustomerDto saveCustomer(CustomerDto customer);

    CustomerDto getCustomerById(UUID uuid);

    CustomerDto updateCustomer(UUID uuid, CustomerDto customer);

}
