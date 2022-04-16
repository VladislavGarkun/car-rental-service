package com.ibagroup.carrental.endpoint.car;

import com.ibagroup.carrental.service.car.CarService;
import com.ibagroup.carrental.service.dto.car.CarDto;
import com.ibagroup.carrental.dao.model.car.Car;
import com.ibagroup.carrental.service.dto.car.CarRegistrationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addCar(@RequestBody CarRegistrationDto carRegistrationDto) {
        ResponseEntity entity = carService.addCar(carRegistrationDto);

        return entity;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CarDto>> findAllCars(){
        List<CarDto> carDtoList = carService.findAllCars();

        return ResponseEntity.ok(carDtoList);
    }

    @GetMapping(value = "/{carId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getCarById(@PathVariable("carId") Long carId){
        CarDto carDto = carService.findCarById(carId);

        return ResponseEntity.ok(carDto);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCar(@RequestBody CarDto carDto){
        Car entity = carService.updateCar(carDto);

        return ResponseEntity.ok(entity);
    }

    @DeleteMapping(value = "/{carId}")
    public void deleteCarById(@PathVariable Long carId){

        carService.deleteCarById(carId);
    }

}
