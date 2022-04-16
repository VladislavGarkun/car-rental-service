package com.ibagroup.carrental.dao.model.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ibagroup.carrental.dao.model.userRole.UserRole;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class User {

    /**
     * Уникальный идентификатор записи
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_role_id")
    private UserRole userRole;

    /**
     * Никнейм пользователя
     */
    @Column(name = "user_name")
    @Size(message = "user_name{User.size}", max = 100)
    private String userName;

    /**
     * Имя пользователя
     */
    @Column(name = "first_name")
    @Size(message = "first_name{User.size}", max = 100)
    private String firstName;

    /**
     * Фамилия пользователя
     */
    @Column(name = "last_name")
    @Size(message = "last_name", max = 100)
    private String lastName;

    /**
     * Почта пользователя
     */
    @Column(name = "email")
    @Size(message = "email{User.size}", max = 100)
    private String email;

    /**
     * Пароль пользователя
     */
    @Column(name = "password")
    @Size(message = "password{User.size}", max = 100)
    private String password;

    /**
     * Телефон пользователя
     */
    @Column(name = "phone")
    @Size(message = "phone{User.size}", max = 100)
    private String phone;

}
