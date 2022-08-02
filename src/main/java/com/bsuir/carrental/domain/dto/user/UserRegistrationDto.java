package com.bsuir.carrental.domain.dto.user;

import lombok.Data;

@Data
public class UserRegistrationDto {

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
     * Повторный пароль пользователя
     */
    private String passwordRepeat;

    /**
     * Телефон пользователя
     */
    private String phone;

}