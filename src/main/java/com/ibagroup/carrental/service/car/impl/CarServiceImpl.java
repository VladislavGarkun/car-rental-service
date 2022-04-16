package com.ibagroup.carrental.service.car.impl;

import com.ibagroup.carrental.dao.model.car.Car;
import com.ibagroup.carrental.dao.repository.car.CarRepository;
import com.ibagroup.carrental.service.car.CarService;
import com.ibagroup.carrental.service.dto.OperationMessageDto;
import com.ibagroup.carrental.service.dto.car.CarDto;
import com.ibagroup.carrental.service.dto.car.CarRegistrationDto;
import com.ibagroup.carrental.service.mapper.car.CarMapper;
import com.ibagroup.carrental.service.mapper.car.CarRegistrationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final static String EMPTY_FIELDS = "You are didn't fill in all required fields";

    private final CarRepository carRepository;
    private final CarRegistrationMapper carRegistrationMapper;
    private final CarMapper carMapper;

    @Override
    public List<CarDto> findAllCars() {
        List<Car> cars = carRepository.findAll();

        return carMapper.toListDto(cars);
    }

    @Override
    public CarDto findCarById(Long id) {
        Car car = carRepository.findById(id).get();

        return carMapper.toDto(car);
    }

    @Override
    public ResponseEntity addCar(CarRegistrationDto carRegistrationDto) {
        if(carRegistrationDto.getBrand().isEmpty() ||
                carRegistrationDto.getModel().isEmpty() ||
                carRegistrationDto.getBody().isEmpty() ||
                carRegistrationDto.getYearOfIssue() == null ||
                carRegistrationDto.getNumberOfSeats() == null ||
                carRegistrationDto.getTransmission().isEmpty() ||
                carRegistrationDto.getPrice() == null ||
                carRegistrationDto.getStatus().isEmpty()
        ){
            return ResponseEntity.badRequest().body(new OperationMessageDto(EMPTY_FIELDS));
        }

        Car car = carRegistrationMapper.toEntity(carRegistrationDto);
        carRepository.save(car);

        CarDto carDto = carMapper.toDto(car);

        return ResponseEntity.ok(carDto);
    }

    @Override
    public Car updateCar(CarDto carDto) {
        return carRepository.save(carMapper.toEntity(carDto));
    }

    @Override
    public void deleteCarById(Long carId) {
        carRepository.deleteById(carId);
    }

}
