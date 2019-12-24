package com.course.msscbrewbery.web.controller;

import com.course.msscbrewbery.services.CustomerService;
import com.course.msscbrewbery.web.model.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/{customerId}"})
    ResponseEntity<CustomerDto> getCustomerById(@PathVariable("customerId") UUID uuid) {
        return new ResponseEntity<>(customerService.getCustomerById(uuid), HttpStatus.OK);    }
}
