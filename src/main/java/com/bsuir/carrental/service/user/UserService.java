package com.bsuir.carrental.service.user;

import com.bsuir.carrental.domain.dto.user.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    UserDto findUserById(Long id);

    UserDto findByUserName(String userName);

    List<UserDto> findAllUsers();

    ResponseEntity updateUser(UserDto userDto);

}
