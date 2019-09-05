package com.springframework.msscbrewery.services;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springframework.msscbrewery.web.model.CustomerDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService{

	@Override
	public CustomerDto getCustomerById(UUID customerId) {
		return CustomerDto.builder().id(UUID.randomUUID())
				.firstName("Siddharth")
				.lastName("Shankar")
				.build();
	}

	@Override
	public CustomerDto saveNewCustomer(UUID customerId) {
		return CustomerDto.builder().id(UUID.randomUUID())
				.build();
	}

	@Override
	public void updateCustomer(UUID customerId, CustomerDto customerDto) {
		log.debug("updating customer");
	}

	@Override
	public void deleteCustomerById(UUID customerId) {
		log.debug("deleting customer");
	}
	
	
	
}
