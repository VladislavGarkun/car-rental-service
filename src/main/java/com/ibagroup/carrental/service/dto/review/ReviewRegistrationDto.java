package com.ibagroup.carrental.service.dto.review;

import lombok.Data;

@Data
public class ReviewRegistrationDto {

    /**
     * Имя пользователя
     */
    private String userName;

    /**
     * Уникальный идентификатор автомобиля
     */
    private Long carId;

    /**
     * Оценка оставленная пользователем
     */
    private Integer mark;

    /**
     * Комментарий пользователя
     */
    private String comment;

}