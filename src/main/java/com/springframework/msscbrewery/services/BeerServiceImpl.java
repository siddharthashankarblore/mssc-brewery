package com.springframework.msscbrewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.springframework.msscbrewery.web.model.BeerDto;

@Service
public class BeerServiceImpl implements BeerService {
	
	@Override
	public BeerDto getBeerById(UUID beerId) {
		
		return BeerDto.builder().id(UUID.randomUUID())
				.beerName("Budwiser")
				.beerStyle("Strong")
				.build();
		
	}
	
	

}
