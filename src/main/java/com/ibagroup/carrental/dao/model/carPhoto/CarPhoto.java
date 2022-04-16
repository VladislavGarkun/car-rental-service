package com.ibagroup.carrental.dao.model.carPhoto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ibagroup.carrental.dao.model.car.Car;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "car_photos")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class CarPhoto {

    /**
     * Уникальный идентификатор записи
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    /**
     * Ссылка на фоторграфию
     */
    @Column(name = "photo_url")
    @Size(message = "photo_url{CarPhoto.size}", max = 1000)
    private String photoUrl;

}