package com.bsuir.carrental.dao.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessages {

    EMPTY_FIELDS("You are didn't fill in all required fields"),
    TAKEN_USERNAME("This username is already taken"),
    TAKEN_EMAIL("This email is already taken"),
    DONT_MATCH_PASSWORDS("Entered passwords are don't match"),
    INVALID_USERNAME_PASSWORD("Invalid username/password supplied"),
    DONT_USE_REQUIRED_SYMBOLS("Please use lowercase letters and uppercase letters and numbers in your password and enter no less then 8 symbols"),
    DISCOUNT_VALUE("You entered incorrect value. Please use a number from 1 to 99"),
    DATE_MISMATCH("Start date can't be later than end date");

    private String message;
}