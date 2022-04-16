package com.ibagroup.carrental.dao.model.car;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cars")
@Data
public class Car {

    /**
     * Уникальный идентификатор записи
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Наименование бренда производителя
     */
    @Column(name = "brand")
    @Size(message = "brand{Car.size}", max = 100)
    private String brand;

    /**
     * Наименование модели автомобиля
     */
    @Column(name = "model")
    @Size(message = "model{Car.size}", max = 100)
    private String model;

    /**
     * Тип кузова автомобиля
     */
    @Column(name = "body")
    @Size(message = "body{Car.size}", max = 100)
    private String body;

    /**
     * Год выпуска автомобиля
     */
    @Column(name = "year_of_issue")
    private Integer yearOfIssue;

    /**
     * Количество мест для пассажиров
     */
    @Column(name = "number_of_seats")
    private Integer numberOfSeats;

    /**
     * Тип коробки передач
     */
    @Column(name = "transmission")
    @Size(message = "transmission{Car.size}", max = 100)
    private String transmission;

    /**
     * Стоимость аренды автомобиля на сутки
     */
    @Column(name = "price")
    private Float price;

    /**
     * Статус доступности автомобиля
     */
    @Column(name = "status")
    @Size(message = "status{Car.size}", max = 100)
    private String status;

}