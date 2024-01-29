package com.LBG.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.LBG.demo.Carsrepo.CarsRepo;
import com.LBG.demo.domain.Cars;

@Service
public class Carsservice {

	private CarsRepo repo;

	public Carsservice(CarsRepo repo, ArrayList<Cars> cars) {
		super();
		this.repo = repo;

	}

	ArrayList<Cars> cars = new ArrayList<>();

	public ResponseEntity<Cars> createCar(Cars newCars) {
		Cars created = this.repo.save(newCars);
//		Cars body = this.cars.get(this.cars.size() - 1);
//		return cars.toString();
//		return this.cars.get(this.cras.sixe() - 1);.
		return new ResponseEntity<Cars>(created, HttpStatus.CREATED);
//		this is to change the created to a full created to let the use know created 
	}

	public boolean deleteCar(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	public ResponseEntity<Cars> getCars(int id) {
		Optional<Cars> found = this.repo.findById(id);

		if (found.isEmpty()) { // checks if it's found a hero
			return new ResponseEntity<Cars>(HttpStatus.NOT_FOUND);
		}

		// attempts to pull the contents out of the box
		Cars body = found.get();

		return ResponseEntity.ok(body);
	}
//		return this.cars.get(id);

	public ResponseEntity<Cars> UpdateCar(int id, Cars newCars) {
		Optional<Cars> found = this.repo.findById(id);

		if (found.isEmpty()) { // checks if it's found a hero
			return new ResponseEntity<Cars>(HttpStatus.NOT_FOUND);
		}

		// attempts to pull the contents out of the box
		Cars existing = found.get();

		if (newCars.getMake() != null) {
			existing.setMake(newCars.getMake());
		}

		if (newCars.getModel() != null) {
			existing.setModel(newCars.getModel());
		}

		Cars updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);
//		this returns the removed one. 
	}

	public List<Cars> getaCar() {
		return this.repo.findAll();
	}

	public String greeting() {
		return "Hello, World!";
	}

}
