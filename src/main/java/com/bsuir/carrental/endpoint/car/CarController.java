package com.bsuir.carrental.endpoint.car;

import com.bsuir.carrental.domain.dto.car.CarDto;
import com.bsuir.carrental.domain.dto.car.CarRegistrationDto;
import com.bsuir.carrental.domain.dto.carPhoto.CarPhotoDto;
import com.bsuir.carrental.domain.dto.carPhoto.CarPhotoRegistrationDto;
import com.bsuir.carrental.service.car.CarService;
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
    public ResponseEntity<List<CarDto>> getAllCars(){
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
        CarDto updatedCar = carService.updateCar(carDto);

        return ResponseEntity.ok(updatedCar);
    }

    @DeleteMapping(value = "/{carId}")
    public void deleteCarById(@PathVariable Long carId){
        carService.deleteCarById(carId);
    }

    @PostMapping(value = "/photo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addCarPhoto(@RequestBody CarPhotoRegistrationDto carPhotoRegistrationDto){
        ResponseEntity entity = carService.addCarPhoto(carPhotoRegistrationDto);

        return entity;
    }

    @GetMapping(value = "/photo/{carId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getCarPhotosByCarId(@PathVariable("carId") Long carId){
        List<CarPhotoDto> carPhotoDtoList = carService.findCarPhotosByCarId(carId);

        return ResponseEntity.ok(carPhotoDtoList);
    }

    @GetMapping(value = "/photo/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CarPhotoDto> getAllCarPhotos(){
        List<CarPhotoDto> carPhotoDtoList = carService.findAllCarPhotos();

        return carPhotoDtoList;
    }

    @DeleteMapping(value = "/photo{carId}")
    public void deleteCarPhotosByCarId(@PathVariable("carId") Long carId){
        carService.deleteCarPhotosByCarId(carId);
    }

}