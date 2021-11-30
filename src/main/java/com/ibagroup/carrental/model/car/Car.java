package com.ibagroup.carrental.model.car;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ibagroup.carrental.model.carPhoto.CarPhoto;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cars")
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String body;
    private Integer yearOfIssue;
    private Integer numberOfSeats;
    private String transmission;
    private Float price;

    @Enumerated(EnumType.STRING)
    private CarStatus status;

}
