package com.ibagroup.carrental.controller.car;

import com.ibagroup.carrental.dto.car.CarDto;
import com.ibagroup.carrental.model.car.Car;
import com.ibagroup.carrental.service.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v2/car")
public class CarController {

    private Map<Long, CarDto> cars = new HashMap<>();

    private final CarService service;

    @Autowired
    public CarController(CarService service){
        this.service = service;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addCar(@RequestBody CarDto car) {
        Car entity = service.addCar(car);

        return ResponseEntity.ok(entity);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Car>> getAllCars(){
        List<Car> cars = service.getAllCars();

        return ResponseEntity.ok(cars);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/{carId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getCarById(@PathVariable("carId") Long carId){
        Car car = service.getCarById(carId);

        return ResponseEntity.ok(car);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCar(@RequestBody Car car){
        Car entity = service.updateCar(car);

        return ResponseEntity.ok(entity);
    }

    @DeleteMapping(value = "/{carId}")
    public void deleteCarById(@PathVariable Long carId){

        service.deleteCarById(carId);
    }

}
