package com.ibagroup.carrental.service.user;

import com.ibagroup.carrental.dao.model.user.User;
import com.ibagroup.carrental.service.dto.user.UserAuthorizationDto;
import com.ibagroup.carrental.service.dto.user.UserDto;
import com.ibagroup.carrental.service.dto.user.UserRegistrationDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    UserDto findUserById(Long id);

    UserDto findByUserName(String userName);

    List<UserDto> findAllUsers();

    ResponseEntity signIn(UserAuthorizationDto userAuthorizationDto);

    ResponseEntity signUp(UserRegistrationDto userRegistrationDto);

    User updateUser(UserDto userDto);

    void deleteUserById(Long userid);

}
