package com.bsuir.carrental.dao.model.userRole;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_role")
@Data
public class UserRole {

    /**
     * Уникальный идентификатор пользователя
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Роль пользователя в системе
     */
    @Column(name = "role")
    @Size(message = "role{UserRole.size}", max = 100)
    private String role;

}
