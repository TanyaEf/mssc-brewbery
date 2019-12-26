package com.course.msscbrewbery.services;

import com.course.msscbrewbery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public void deleteCustomer(UUID uuid) {
      log.debug("Customer deleted. UUID: " + uuid);
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customer) {
        return CustomerDto.builder()
                .uuid(UUID.randomUUID())
                .build();
    }

    @Override
    public CustomerDto getCustomerById(UUID uuid) {
        return CustomerDto.builder()
                .uuid(UUID.randomUUID())
                .name("John Doe")
                .build();
    }

    @Override
    public CustomerDto updateCustomer(UUID uuid, CustomerDto customer) {
        return CustomerDto.builder()
                .uuid(UUID.randomUUID())
                .build();
    }
}
