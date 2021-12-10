package com.ibagroup.carrental.repo.carPhoto;

import com.ibagroup.carrental.model.carPhoto.CarPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarPhotoRepo extends JpaRepository<CarPhoto, Long> {

    @Query(value = "select p from CarPhoto p where p.car.id = :carId")
    List<CarPhoto> findByCarId(Long carId);

}
