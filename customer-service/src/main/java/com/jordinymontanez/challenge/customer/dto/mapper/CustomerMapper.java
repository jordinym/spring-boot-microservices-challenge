package com.jordinymontanez.challenge.customer.dto.mapper;

import com.jordinymontanez.challenge.customer.dto.CustomerDto;
import com.jordinymontanez.challenge.customer.model.Customer;

public class CustomerMapper {
    public static Customer toCustomer(CustomerDto customerDto) {
        return  Customer.builder()
                .id(customerDto.getId())
                .name(customerDto.getName())
                .lastName(customerDto.getLastName())
                .birthDate(customerDto.getBirthDate())
                .age(customerDto.getAge()).build();
    }
    public static CustomerDto toCustomerDto(Customer customer) {
        return  CustomerDto.builder()
                .id(customer.getId())
                .name(customer.getName())
                .lastName(customer.getLastName())
                .birthDate(customer.getBirthDate())
                .age(customer.getAge()).build();
    }
}
