package com.ibagroup.carrental.model.userRole;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;

}
