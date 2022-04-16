package com.ibagroup.carrental.service.dto.userRole;

import lombok.Data;

@Data
public class UserRoleDto {

    /**
     * Уникальный идентификатор пользователя
     */
    private Long id;

    /**
     * Роль пользователя
     */
    private String role;

}
