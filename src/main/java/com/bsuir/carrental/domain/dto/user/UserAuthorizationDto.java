package com.bsuir.carrental.domain.dto.user;

import lombok.Data;

@Data
public class UserAuthorizationDto {

    /**
     * Никнейм пользователя
     */
    private String userName;

    /**
     * Пароль пользователя
     */
    private String password;

}