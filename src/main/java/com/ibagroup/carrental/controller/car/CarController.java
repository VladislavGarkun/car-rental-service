package com.ibagroup.carrental.controller.car;

import com.ibagroup.carrental.dto.car.CarDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v2/car")
public class CarController {

    private Map<Long, CarDto> cars = new HashMap<>();

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity addCar(@RequestBody CarDto car) {
        long latestId = cars.size();
        car.setId(latestId);
        cars.put(latestId, car);

        return ResponseEntity.ok(car);
    }

    @GetMapping(value = "{carId}", produces = "application/json")
    public ResponseEntity getCarById(@PathVariable Long carId){
        CarDto car = cars.get(carId);

        return ResponseEntity.ok(car);
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity updateCar(@RequestBody CarDto car){
        cars.put(car.getId(), car);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{carId}", produces = "application/json")
    public ResponseEntity deleteCar(@PathVariable Long carId){
        CarDto car = cars.remove(carId);

        return ResponseEntity.ok(car);
    }

}
