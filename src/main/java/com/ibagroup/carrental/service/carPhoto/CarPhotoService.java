package com.ibagroup.carrental.service.carPhoto;

import com.ibagroup.carrental.dto.carPhoto.CarPhotoDto;
import com.ibagroup.carrental.model.car.Car;
import com.ibagroup.carrental.model.carPhoto.CarPhoto;
import com.ibagroup.carrental.repo.car.CarRepo;
import com.ibagroup.carrental.repo.carPhoto.CarPhotoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarPhotoService {

    private final CarPhotoRepo repo;

    private final CarRepo carRepo;

    public CarPhotoService(CarPhotoRepo repo, CarRepo carRepo){
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

    public List<CarPhoto> getAllCarPhotos() {
        return repo.findAll();
    }

    public CarPhoto updateCarPhoto(CarPhoto carPhoto) {
        return repo.save(carPhoto);
    }

    public void deleteCarPhotoById(Long carPhotoId) {
        repo.deleteById(carPhotoId);
    }
}
