package com.bsuir.carrental.domain.mapper.user;

import com.bsuir.carrental.dao.model.user.User;
import com.bsuir.carrental.domain.dto.user.UserRegistrationDto;

public interface UserRegistrationMapper {

    User toEntity(UserRegistrationDto userRegistrationDto);

}