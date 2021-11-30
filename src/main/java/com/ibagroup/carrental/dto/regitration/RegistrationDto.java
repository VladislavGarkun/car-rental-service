package com.ibagroup.carrental.dto.regitration;

import lombok.Data;

@Data
public class RegistrationDto {

    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String passwordRepeat;
    private String phone;

}