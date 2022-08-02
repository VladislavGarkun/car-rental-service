package com.bsuir.carrental.domain.dto.order;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderRegistrationDto {

    /**
     * Уникальный идентификатор автомобиля
     */
    private Long carId;

    /**
     * Имя пользователя
     */
    private String userName;

    /**
     * Дата начала аренды
     */
    private LocalDate startDate;

    /**
     * Дата окончания аренды
     */
    private LocalDate endDate;

}