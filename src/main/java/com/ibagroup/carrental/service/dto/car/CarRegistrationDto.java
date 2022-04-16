package com.ibagroup.carrental.service.dto.car;

import lombok.Data;

@Data
public class CarRegistrationDto {

    /**
     * Наименование бренда производителя
     */
    private String brand;

    /**
     * Наименование модели автомобиля
     */
    private String model;

    /**
     * Тип кузова автомобиля
     */
    private String body;

    /**
     * Год выпуска автомобиля
     */
    private Integer yearOfIssue;

    /**
     * Количество мест для пассажиров
     */
    private Integer numberOfSeats;

    /**
     * Тип коробки передач
     */
    private String transmission;

    /**
     * Стоимость аренды автомобиля на сутки
     */
    private Float price;

    /**
     * Статус доступности автомобиля
     */
    private String status;

}
