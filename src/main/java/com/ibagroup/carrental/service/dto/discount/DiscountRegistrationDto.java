package com.ibagroup.carrental.service.dto.discount;

import lombok.Data;

@Data
public class DiscountRegistrationDto {

    /**
     * Название скидки
     */
    private String name;

    /**
     * Значение скидки
     */
    private Float value;

}