package com.bsuir.carrental.service.car.impl;

import com.bsuir.carrental.dao.repository.car.CarRepository;
import com.bsuir.carrental.dao.repository.carPhoto.CarPhotoRepository;
import com.bsuir.carrental.domain.dto.carPhoto.CarPhotoDto;
import com.bsuir.carrental.service.car.CarService;
import com.bsuir.carrental.dao.enums.ErrorMessages;
import com.bsuir.carrental.dao.model.car.Car;
import com.bsuir.carrental.dao.model.carPhoto.CarPhoto;
import com.bsuir.carrental.domain.dto.carPhoto.CarPhotoRegistrationDto;
import com.bsuir.carrental.domain.mapper.carPhoto.CarPhotoMapper;
import com.bsuir.carrental.domain.dto.OperationMessageDto;
import com.bsuir.carrental.domain.dto.car.CarDto;
import com.bsuir.carrental.domain.dto.car.CarRegistrationDto;
import com.bsuir.carrental.domain.mapper.car.CarMapper;
import com.bsuir.carrental.domain.mapper.car.CarRegistrationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarRegistrationMapper carRegistrationMapper;
    private final CarMapper carMapper;
    private final CarPhotoRepository carPhotoRepository;
    private final CarPhotoMapper carPhotoMapper;

    @Override
    public List<CarDto> findAllCars() {
        List<Car> cars = carRepository.findAll();

        return carMapper.toListDto(cars);
    }

    @Override
    public CarDto findCarById(Long carId) {
        Car car = carRepository.findById(carId).get();

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
            return ResponseEntity.badRequest().body(new OperationMessageDto(ErrorMessages.EMPTY_FIELDS.getMessage()));
        }

        Car car = carRegistrationMapper.toEntity(carRegistrationDto);
        carRepository.save(car);

        CarDto carDto = carMapper.toDto(car);

        return ResponseEntity.ok(carDto);
    }

    @Override
    public CarDto updateCar(CarDto carDto) {
        Car updatedCar = carRepository.save(carMapper.toEntity(carDto));

        return carMapper.toDto(updatedCar);
    }

    @Override
    public void deleteCarById(Long carId) {
        carRepository.deleteById(carId);
    }

    @Override
    public ResponseEntity addCarPhoto(CarPhotoRegistrationDto carPhotoRegistrationDto) {
        if (carPhotoRegistrationDto.getPhotoUrl().isEmpty()){
            return ResponseEntity.badRequest().body(new OperationMessageDto(ErrorMessages.EMPTY_FIELDS.getMessage()));
        }
        List<CarPhoto> carPhotoList = new ArrayList<>();
        String[] photoUrls = carPhotoRegistrationDto.getPhotoUrl().split("\n");

        for (int i = 0; i < photoUrls.length; i++){
            CarPhoto entity = new CarPhoto();
            entity.setCar(carRepository.findById(carPhotoRegistrationDto.getCarId()).get());
            entity.setPhotoUrl(photoUrls[i]);
            carPhotoRepository.save(entity);
            carPhotoList.add(entity);
        }

        List<CarPhotoDto> carPhotoDtoList = carPhotoMapper.toListDto(carPhotoList);
        for (int i = 0; i < carPhotoDtoList.size(); i++){
            carPhotoDtoList.get(i).setCar(carMapper.toDto(carPhotoList.get(i).getCar()));
        }

        return ResponseEntity.ok(carPhotoDtoList);
    }

    @Override
    public List<CarPhotoDto> findAllCarPhotos() {
       List<CarPhoto> carPhotoList = carPhotoRepository.findAll();

        List<CarPhotoDto> carPhotoDtoList = carPhotoMapper.toListDto(carPhotoList);
        for (int i = 0; i < carPhotoDtoList.size(); i++){
            carPhotoDtoList.get(i).setCar(carMapper.toDto(carPhotoList.get(i).getCar()));
        }

        return carPhotoDtoList;
    }

    @Override
    public void deleteCarPhotosByCarId(Long carId) {
        carPhotoRepository.deleteCarPhotoByCar_Id(carId);
    }

    @Override
    public List<CarPhotoDto> findCarPhotosByCarId(Long carId) {
        return carPhotoMapper.toListDto(carPhotoRepository.findCarPhotoByCar_Id(carId));
    }

}
