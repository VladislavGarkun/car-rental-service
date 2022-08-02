package com.bsuir.carrental.domain.dto.review;

import lombok.Data;

@Data
public class ReviewRegistrationDto {

    /**
     * Имя пользователя
     */
    private String userName;

    /**
     * Оценка оставленная пользователем
     */
    private Integer mark;

    /**
     * Комментарий пользователя
     */
    private String comment;

}