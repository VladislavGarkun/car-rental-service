package com.ibagroup.carrental.service;

import com.ibagroup.carrental.service.dto.carPhoto.CarPhotoDto;
import com.ibagroup.carrental.dao.model.carPhoto.CarPhoto;
import com.ibagroup.carrental.dao.repository.car.CarRepository;
import com.ibagroup.carrental.dao.repository.carPhoto.CarPhotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarPhotoService {

    private final CarPhotoRepository repo;

    private final CarRepository carRepo;

    public CarPhotoService(CarPhotoRepository repo, CarRepository carRepo){
        this.repo = repo;
        this.carRepo = carRepo;
    }

    public CarPhoto addCarPhoto(CarPhotoDto carPhoto) {
        CarPhoto entity = new CarPhoto();
        entity.setCar(carRepo.findById(carPhoto.getCarId()).get());
        entity.setPhotoUrl(carPhoto.getPhotoUrl());

        repo.save(entity);

        return entity;
    }

    public CarPhoto getCarPhotoById(Long carPhotoId) {
        return repo.findById(carPhotoId).get();
    }

    public List<CarPhoto> findAllCarPhotos() {
        return repo.findAll();
    }

    public CarPhoto updateCarPhoto(CarPhoto carPhoto) {
        return repo.save(carPhoto);
    }

    public void deleteCarPhotoById(Long carPhotoId) {
        repo.deleteById(carPhotoId);
    }

    public List<CarPhoto> findCarPhotosByCarId(Long carId) {
        return repo.findByCarId(carId);
    }
}
