package com.ibagroup.carrental.repo.car;

import com.ibagroup.carrental.dto.car.CarDto;
import com.ibagroup.carrental.model.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CarRepo extends JpaRepository<Car, Long> {



}
