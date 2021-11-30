package com.ibagroup.carrental.model.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ibagroup.carrental.model.blackList.BlackList;
import com.ibagroup.carrental.model.userRole.UserRole;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_role_id")
    private UserRole userRole;

    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;

}
