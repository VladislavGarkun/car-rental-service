package com.ibagroup.carrental.dto.carPhoto;

import lombok.Data;

@Data
public class CarPhotoDto {

    private Long id;
    private Long carId;
    private String photoUrl;

}
