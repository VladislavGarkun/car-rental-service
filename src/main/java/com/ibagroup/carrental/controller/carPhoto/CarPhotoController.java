package com.ibagroup.carrental.controller.carPhoto;

import com.ibagroup.carrental.dto.carPhoto.CarPhotoDto;
import com.ibagroup.carrental.model.car.Car;
import com.ibagroup.carrental.model.carPhoto.CarPhoto;
import com.ibagroup.carrental.service.carPhoto.CarPhotoService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/carphoto")
public class CarPhotoController {

    private final CarPhotoService service;

    public CarPhotoController(CarPhotoService service){
        this.service = service;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addCarPhoto(@RequestBody CarPhotoDto carPhoto){
        CarPhoto entity = service.addCarPhoto(carPhoto);

        return ResponseEntity.ok(entity);
    }

    @GetMapping(value = "/{carPhotoId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getCarPhotoById(@PathVariable("carPhotoId") Long carPhotoId){
        CarPhoto carPhoto = service.getCarPhotoById(carPhotoId);

        return ResponseEntity.ok(carPhoto);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CarPhoto> getAllCarPhotos(){
        List<CarPhoto> carPhotos = service.getAllCarPhotos();

        return carPhotos;
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCarPhoto(@RequestBody CarPhoto carPhoto){
        CarPhoto entity = service.updateCarPhoto(carPhoto);

        return ResponseEntity.ok(entity);
    }

    @DeleteMapping(value = "{carPhotoId}")
    public void deleteCarPhotoById(@PathVariable Long carPhotoId){
        service.deleteCarPhotoById(carPhotoId);
    }
}
