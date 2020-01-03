package com.course.msscbrewbery.web.controller;

import com.course.msscbrewbery.services.CustomerService;
import com.course.msscbrewbery.web.model.CustomerDto;
import com.course.msscbrewbery.web.model.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        return new ResponseEntity<>(customerService.getCustomerById(uuid), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> addCustomer(@Valid @RequestBody CustomerDto Customer) {
        CustomerDto savedCustomerDto = customerService.saveCustomer(Customer);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/api/v1/customer/" + savedCustomerDto.getUuid().toString());
        return new ResponseEntity<>(savedCustomerDto, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable("customerId")UUID uuid, @Valid @RequestBody CustomerDto Customer) {
        CustomerDto updatedCustomerDto = customerService.updateCustomer(uuid, Customer);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/api/v1/customer/" + updatedCustomerDto.getUuid().toString());
        return new ResponseEntity<>(updatedCustomerDto, httpHeaders, HttpStatus.OK);
    }

    @DeleteMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomerById(@PathVariable("customerId")UUID uuid) {
        customerService.deleteCustomer(uuid);
    }


}
