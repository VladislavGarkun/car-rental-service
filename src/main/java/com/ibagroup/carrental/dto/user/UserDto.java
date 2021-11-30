package com.ibagroup.carrental.dto.user;

import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private Long userRoleId;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;

}
