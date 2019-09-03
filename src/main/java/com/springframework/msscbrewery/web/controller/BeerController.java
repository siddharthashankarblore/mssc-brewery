package com.springframework.msscbrewery.web.controller;

import java.util.UUID;

import org.springframework.beans.factory.config.YamlProcessor.ResolutionMethod;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springframework.msscbrewery.services.BeerService;
import com.springframework.msscbrewery.web.model.BeerDto;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
	
	private final BeerService beerService;

	public BeerController(BeerService beerService) {
		this.beerService = beerService;
	}
	
	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){
		return new ResponseEntity<BeerDto>(beerService.getBeerById(beerId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<BeerDto> handlePost(@RequestBody BeerDto beerDto) {

		BeerDto savedBeerDto = beerService.saveNewBeer(beerDto);
		HttpHeaders headers = new HttpHeaders();
		// to do add host name to url
		headers.add("Location","/api/v1/beer" + savedBeerDto.getId().toString());
		return new ResponseEntity<BeerDto>(headers, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{beerId}")
	public ResponseEntity<BeerDto> handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto){
		beerService.updateBeer(beerId, beerDto);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping({"/{beerId}"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void handleDelete(@PathVariable("beerId") UUID beerId) {
		beerService.deleteById(beerId);
	}

}
