package com.LBG.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LBG.demo.domain.Cars;
import com.LBG.demo.service.Carsservice;

@RestController
@RequestMapping("/cars")
public class CarsController {

	private Carsservice service;

	public CarsController(Carsservice service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Cars> createCar(@RequestBody Cars newCars) {
		return this.service.createCar(newCars);
//		return cars.toString();
//		return this.cars.get(this.cras.sixe() - 1);.

//		this is to change the created to a full created to let the use know created 
	}

	@DeleteMapping("/delete/{id}")
	public void deleteCar(@PathVariable int id) {
		this.service.deleteCar(id);
		return;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Cars> getCars(@PathVariable int id) {
		return this.service.getCars(id);

	}

	@PatchMapping("/update/{id}")
	public ResponseEntity<Cars> UpdateCar(@PathVariable int id, @RequestBody Cars newCars) {
		return this.service.UpdateCar(id, newCars);
//		this returns the removed one. 
	}

	@GetMapping("/get")
	public List<Cars> getaCar() {
		return this.service.getaCar();
	}

	@GetMapping("/hello")
	public String greeting() {
		return "Hello, World!";
	}

}
