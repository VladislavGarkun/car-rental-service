package com.ibagroup.carrental.service.dto.order;

import com.ibagroup.carrental.service.dto.car.CarDto;
import com.ibagroup.carrental.service.dto.user.UserDto;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderDto {

    /**
     * Уникальный идентификатор записи
     */
    private Long id;

    private UserDto user;

    private CarDto car;

    /**
     * Дата начала действия заказа
     */
    private LocalDate startDate;

    /**
     * Дата окончания действия заказа
     */
    private LocalDate endDate;

    /**
     * Стоимость заказа
     */
    private Float price;

    /**
     * Статус заказа
     */
    private String status;

}