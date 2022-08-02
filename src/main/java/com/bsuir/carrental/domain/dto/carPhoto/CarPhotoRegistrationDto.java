package com.bsuir.carrental.domain.dto.carPhoto;

import lombok.Data;

@Data
public class CarPhotoRegistrationDto {

    /**
     * Уникальный идентификатор автомобиля
     */
    private Long carId;

    /**
     * Ссылка на фотографии автомобилей
     */
    private String photoUrl;

}