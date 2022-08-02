package com.bsuir.carrental.service.car;

import com.bsuir.carrental.domain.dto.car.CarDto;
import com.bsuir.carrental.domain.dto.car.CarRegistrationDto;
import com.bsuir.carrental.domain.dto.carPhoto.CarPhotoDto;
import com.bsuir.carrental.domain.dto.carPhoto.CarPhotoRegistrationDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CarService {

    List<CarDto> findAllCars();

    CarDto findCarById(Long id);

    ResponseEntity addCar(CarRegistrationDto carRegistrationDto);

    CarDto updateCar(CarDto carDto);

    void deleteCarById(Long carId);

    ResponseEntity addCarPhoto(CarPhotoRegistrationDto carPhotoRegistrationDto);

    List<CarPhotoDto> findAllCarPhotos();

    void deleteCarPhotosByCarId(Long carId);

    List<CarPhotoDto> findCarPhotosByCarId(Long carId);

}