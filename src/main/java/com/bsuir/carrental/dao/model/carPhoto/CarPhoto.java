package com.bsuir.carrental.dao.model.carPhoto;

import com.bsuir.carrental.dao.model.car.Car;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "car_photos")
public class CarPhoto {

    /**
     * Уникальный идентификатор записи
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Автомобиль к которому относятся фотографии
     */
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    /**
     * Ссылки на фотографии автомобиля
     */
    @Column(name = "photo_url")
    @Size(message = "photo_url{CarPhoto.size}", max = 1000)
    private String photoUrl;

}