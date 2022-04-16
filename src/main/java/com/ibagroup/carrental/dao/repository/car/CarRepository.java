package com.ibagroup.carrental.dao.repository.car;

import com.ibagroup.carrental.dao.model.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {



}