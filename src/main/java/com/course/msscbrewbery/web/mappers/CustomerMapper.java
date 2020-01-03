package com.course.msscbrewbery.web.mappers;

import com.course.msscbrewbery.domain.Customer;
import com.course.msscbrewbery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    CustomerDto customerToCustomerDto(Customer customer);

    Customer customerDtoToCustomer(CustomerDto customerDto);
}
