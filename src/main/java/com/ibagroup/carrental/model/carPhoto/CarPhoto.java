package com.ibagroup.carrental.model.carPhoto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ibagroup.carrental.model.car.Car;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "car_photos")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class CarPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    private String photoUrl;

}
