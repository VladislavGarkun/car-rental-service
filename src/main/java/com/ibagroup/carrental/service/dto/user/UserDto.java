package com.ibagroup.carrental.service.dto.user;

import com.ibagroup.carrental.service.dto.userRole.UserRoleDto;
import lombok.Data;

@Data
public class UserDto {

    /**
     * Уникальный идентификатор записи
     */
    private Long id;

    /**
     * Уникальный идентификатор роли пользователя
     */
    private UserRoleDto userRoleDto;

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
