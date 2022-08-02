package com.bsuir.carrental.dao.repository.carPhoto;

import com.bsuir.carrental.dao.model.carPhoto.CarPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarPhotoRepository extends JpaRepository<CarPhoto, Long> {

    List<CarPhoto> findCarPhotoByCar_Id(Long carId);

    void deleteCarPhotoByCar_Id(Long carId);

}
