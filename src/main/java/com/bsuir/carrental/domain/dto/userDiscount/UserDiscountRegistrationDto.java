package com.bsuir.carrental.domain.dto.userDiscount;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDiscountRegistrationDto {

    /**
     * Уникальный идентификатор пользователя
     */
    private Long userId;

    /**
     * Уникальный идентификатор скидки
     */
    private Long discountId;

    /**
     * Дата начала действия скидки
     */
    private LocalDate dateOfStart;

    /**
     * Дата окончания действия скидки
     */
    private LocalDate dateOfEnd;

}