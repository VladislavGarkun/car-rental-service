package com.ibagroup.carrental.service.car;

import com.ibagroup.carrental.dao.model.car.Car;
import com.ibagroup.carrental.service.dto.car.CarDto;
import com.ibagroup.carrental.service.dto.car.CarRegistrationDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CarService {

    List<CarDto> findAllCars();

    CarDto findCarById(Long id);

    ResponseEntity addCar(CarRegistrationDto carRegistrationDto);

    Car updateCar(CarDto carDto);

    void deleteCarById(Long carId);

}
