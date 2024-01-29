package com.LBG.demo.Carsrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LBG.demo.domain.Cars;

public interface CarsRepo extends JpaRepository<Cars, Integer> {

}
