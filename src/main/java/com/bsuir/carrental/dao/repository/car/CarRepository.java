package com.bsuir.carrental.dao.repository.car;

import com.bsuir.carrental.dao.model.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {



}