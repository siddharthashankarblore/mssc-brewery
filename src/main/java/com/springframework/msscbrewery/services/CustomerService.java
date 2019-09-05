package com.springframework.msscbrewery.services;

import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.springframework.msscbrewery.web.model.CustomerDto;

public interface CustomerService {
	
	CustomerDto getCustomerById(UUID customerId);
	
	CustomerDto saveNewCustomer(UUID customerId);

	void updateCustomer(UUID customerId, CustomerDto customerDto);

	void deleteCustomerById(UUID customerId);

}
