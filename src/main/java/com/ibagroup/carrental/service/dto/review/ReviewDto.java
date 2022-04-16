package com.ibagroup.carrental.service.dto.review;

import com.ibagroup.carrental.service.dto.car.CarDto;
import com.ibagroup.carrental.service.dto.user.UserDto;
import lombok.Data;

@Data
public class ReviewDto {

    /**
     * Уникальный идентификатор записи
     */
    private Long id;

    private CarDto car;

    private UserDto user;

    /**
     * Оценка оставленная пользователем
     */
    private Integer mark;

    /**
     * Комментарий пользователя
     */
    private String comment;

}
