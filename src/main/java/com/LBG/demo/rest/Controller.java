package com.LBG.demo.rest;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.LBG.demo.domain.Cars;

@RestController
public class Controller {

	ArrayList<Cars> cars = new ArrayList<>();

	@PostMapping("/create")
	public ResponseEntity<Cars> createCar(@RequestBody Cars newCars) {
		this.cars.add(newCars);
		Cars body = this.cars.get(this.cars.size() - 1);
//		return cars.toString();
//		return this.cars.get(this.cras.sixe() - 1);.
		return new ResponseEntity<Cars>(body, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteCar(@PathVariable int id) {
		this.cars.remove(id);
		return;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Cars> getCars(@PathVariable int id) {
		if (id < 0 || id >= this.cars.size()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Cars found = this.cars.get(id);

		return ResponseEntity.ok(found);
	}
//		return this.cars.get(id);

	@PutMapping("/update/{id}")
	public Cars UpdateCar(@PathVariable int id, @RequestBody Cars newCars) {
		return this.cars.set(id, newCars);
//		this returns the removed one. 
	}

	@GetMapping("/get")
	public ArrayList<Cars> getaCar() {
		return cars;
	}

	@GetMapping("/hello")
	public String greeting() {
		return "Hello, World!";
	}

}
