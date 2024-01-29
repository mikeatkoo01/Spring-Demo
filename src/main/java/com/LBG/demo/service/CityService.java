package com.LBG.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.LBG.demo.Carsrepo.CityRepo;
import com.LBG.demo.domain.City;

@Service
public class CityService {

	private CityRepo repo;

	public CityService(CityRepo repo) {
		super();
		this.repo = repo;
	}

//	ArrayList<City> city = new ArrayList<>();

	public ResponseEntity<City> createCity(City newCity) {
		City created = this.repo.save(newCity);
		return new ResponseEntity<City>(created, HttpStatus.CREATED);

	}

	public ResponseEntity<City> readCity(int id) {

		Optional<City> found = this.repo.findById(id);

		if (found.isEmpty()) { // checks if it's found a hero
			return new ResponseEntity<City>(HttpStatus.NOT_FOUND);
		}

		// attempts to pull the contents out of the box
		City body = found.get();

		return ResponseEntity.ok(body);
	}

	public ResponseEntity<City> updateCity(int id, City newCity) {

		Optional<City> found = this.repo.findById(id);

		if (found.isEmpty()) { // checks if it's found a hero
			return new ResponseEntity<City>(HttpStatus.NOT_FOUND);
		}

		// attempts to pull the contents out of the box
		City existing = found.get();

		if (newCity.getName() != null) {
			existing.setName(newCity.getName());
		}

		if (newCity.getCountry() != null) {
			existing.setCountry(newCity.getCountry());
		}

		City updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);

	}

	public boolean deleteCity(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);

	}

	public List<City> getCity() {

		return this.repo.findAll();
	}

}
