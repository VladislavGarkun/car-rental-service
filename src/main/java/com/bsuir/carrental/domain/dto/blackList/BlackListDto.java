package com.bsuir.carrental.domain.dto.blackList;

import com.bsuir.carrental.domain.dto.user.UserDto;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BlackListDto {

    /**
     * Уникальнй идентификатор записи
     */
    private Long id;

    private UserDto user;

    /**
     * Причина занесения в черный список
     */
    private String reason;

    /**
     * Дата занесения в черный список
     */
    private LocalDate dateOfAdd;

}