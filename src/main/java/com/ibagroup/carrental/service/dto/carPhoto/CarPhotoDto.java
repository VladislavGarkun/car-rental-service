package com.ibagroup.carrental.service.dto.carPhoto;

import lombok.Data;

@Data
public class CarPhotoDto {

    private Long id;
    private Long carId;
    private String photoUrl;

}
