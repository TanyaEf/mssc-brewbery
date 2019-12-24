package com.course.msscbrewbery.services;

import com.course.msscbrewbery.web.model.CustomerDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID uuid);
}
