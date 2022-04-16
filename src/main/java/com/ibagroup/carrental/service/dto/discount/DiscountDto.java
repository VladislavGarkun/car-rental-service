package com.ibagroup.carrental.service.dto.discount;

import lombok.Data;

@Data
public class DiscountDto {

    /**
     * Уникальный идентификатор записи
     */
    private Long id;

    /**
     * Название скидки
     */
    private String name;

    /**
     * Значение скидки
     */
    private Float value;

}
