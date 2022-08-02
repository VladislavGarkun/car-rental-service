package com.bsuir.carrental.domain.dto.userDiscount;

import com.bsuir.carrental.domain.dto.discount.DiscountDto;
import com.bsuir.carrental.domain.dto.user.UserDto;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDiscountDto {

    /**
     * Уникальный идентификатор записи
     */
    private Long id;

    /**
     * Пользователь которому принадлежит скидка
     */
    private UserDto user;

    /**
     * Скидка выданная пользователю
     */
    private DiscountDto discount;

    /**
     * Дата начала действия скидки
     */
    private LocalDate dateOfStart;

    /**
     * Дата окончания действия скидки
     */
    private LocalDate dateOfEnd;

}