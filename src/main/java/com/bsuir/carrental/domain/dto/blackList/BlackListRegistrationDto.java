package com.bsuir.carrental.domain.dto.blackList;

import lombok.Data;

@Data
public class BlackListRegistrationDto {

    /**
     * Уникальнй идентификатор пользователя
     */
    private Long userId;

    /**
     * Причина занесения в черный список
     */
    private String reason;

}