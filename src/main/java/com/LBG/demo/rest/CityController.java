package com.LBG.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LBG.demo.domain.City;
import com.LBG.demo.service.CityService;

@RestController
@RequestMapping("/city")
public class CityController {

	private static final int id = 0;
	private CityService service;

	public CityController(CityService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<City> createCity(@RequestBody City newCity) {
		return this.service.createCity(newCity);

	}

	@GetMapping("/read")
	public List<City> readCity() {
		return this.service.getCity();

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<City> updateCity(@PathVariable int id, @RequestBody City newCity) {
		return this.service.updateCity(id, newCity);

	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteCity(@PathVariable int id) {
		return this.service.deleteCity(id);

	}

	@GetMapping("/get/{id}")
	public ResponseEntity<City> getCity(@PathVariable int id) {
		return this.service.readCity(id);

	}

}
