package com.bsuir.carrental.domain.dto.userRole;

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
