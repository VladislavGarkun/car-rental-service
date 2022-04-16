package com.ibagroup.carrental.dao.model.userRole;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_role")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class UserRole {

    /**
     * Уникальный идентификатор пользователя
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Роль пользователя
     */
    @Column(name = "role")
    @Size(message = "role{UserRole.size}", max = 100)
    private String role;

}
