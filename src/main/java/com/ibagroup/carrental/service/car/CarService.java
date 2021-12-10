package com.ibagroup.carrental.service.car;

import com.ibagroup.carrental.dto.car.CarDto;
import com.ibagroup.carrental.model.car.Car;
import com.ibagroup.carrental.repo.car.CarRepo;
import com.ibagroup.carrental.repo.carPhoto.CarPhotoRepo;
import com.ibagroup.carrental.service.carPhoto.CarPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepo repo;

    private final CarPhotoRepo carPhotoRepo;

    @Autowired
    public CarService(CarRepo repo, CarPhotoRepo carPhotoRepo){
        this.repo = repo;
        this.carPhotoRepo = carPhotoRepo;
    }


    public Car addCar(CarDto car) {
        Car entity = new Car();

        entity.setBrand(car.getBrand());
        entity.setModel(car.getModel());
        entity.setBody(car.getBody());
        entity.setYearOfIssue(car.getYearOfIssue());
        entity.setNumberOfSeats(car.getNumberOfSeats());
        entity.setTransmission(car.getTransmission());
        entity.setPrice(car.getPrice());
        entity.setStatus(car.getStatus());

        repo.save(entity);

        return entity;
    }

    public List<Car> getAllCars() {
        return repo.findAll();
    }


    public Car getCarById(Long id) {
        return repo.findById(id).get();
    }

    public Car updateCar(Car car) {
        return repo.save(car);
    }

    public void deleteCarById(Long carId) {
        repo.deleteById(carId);
    }
}
