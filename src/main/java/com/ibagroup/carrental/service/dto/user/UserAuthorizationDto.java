package com.ibagroup.carrental.service.dto.user;

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
