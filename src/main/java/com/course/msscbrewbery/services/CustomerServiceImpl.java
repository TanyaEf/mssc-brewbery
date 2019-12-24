package com.course.msscbrewbery.services;

import com.course.msscbrewbery.web.model.CustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID uuid) {
        return CustomerDto.builder()
                .uuid(UUID.randomUUID())
                .name("John Doe")
                .build();
    }
}
