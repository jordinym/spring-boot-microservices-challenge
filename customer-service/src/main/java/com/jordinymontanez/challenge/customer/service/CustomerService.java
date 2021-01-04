package com.jordinymontanez.challenge.customer.service;

import com.jordinymontanez.challenge.customer.dto.CustomerDto;
import com.jordinymontanez.challenge.customer.dto.CustomerKpiDto;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface CustomerService {
   public List<CustomerDto> getAllEmployees() throws InterruptedException, ExecutionException;
   public CustomerDto createCustomer(CustomerDto customerDto);
   public CustomerKpiDto kpiCustomer();

}
