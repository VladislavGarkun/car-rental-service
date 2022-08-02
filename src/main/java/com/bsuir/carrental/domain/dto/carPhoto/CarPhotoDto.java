package com.bsuir.carrental.domain.dto.carPhoto;

import com.bsuir.carrental.domain.dto.car.CarDto;
import lombok.Data;

@Data
public class CarPhotoDto {

    /**
     * Уникальный идентификатор записи
     */
    private Long id;

    /**
     * Автомобиль к которому относятся фотографии
     */
    private CarDto car;

    /**
     * Ссылки на фотографии автомобиля
     */
    private String photoUrl;

}