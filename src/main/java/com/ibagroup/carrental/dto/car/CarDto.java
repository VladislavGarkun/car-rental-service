package com.ibagroup.carrental.dto.car;

import com.ibagroup.carrental.model.car.CarStatus;
import lombok.Data;


@Data
public class CarDto {

    private Long id;
    private String brand;
    private String body;
    private Integer yearOfIssue;
    private Integer numberOfSeats;
    private String transmission;
    private Float price;
    private CarStatus status;

}

