package com.ibagroup.carrental.service.dto.user;

import lombok.Data;

@Data
public class UserRequestDto {

    /**
     * Никнейм пользователя
     */
    private String userName;

    /**
     * Имя пользователя
     */
    private String firstName;

    /**
     * Фамилия пользователя
     */
    private String lastName;

    /**
     * Почта пользователя
     */
    private String email;

    /**
     * Пароль пользователя
     */
    private String password;

    /**
     * Телефон пользователя
     */
    private String phone;

}
