package com.bsuir.carrental.domain.dto.review;

import com.bsuir.carrental.domain.dto.user.UserDto;
import lombok.Data;

@Data
public class ReviewDto {

    /**
     * Уникальный идентификатор записи
     */
    private Long id;

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
