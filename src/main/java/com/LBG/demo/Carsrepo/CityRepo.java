package com.LBG.demo.Carsrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LBG.demo.domain.City;

public interface CityRepo extends JpaRepository<City, Integer> {

}
