package com.ibagroup.carrental.service.mapper.user;

import com.ibagroup.carrental.dao.model.user.User;
import com.ibagroup.carrental.service.dto.user.UserRegistrationDto;

public interface UserRegistrationMapper {

    User toEntity(UserRegistrationDto userRegistrationDto);

}
