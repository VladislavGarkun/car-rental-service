package com.bsuir.carrental.domain.mapper.user;

import com.bsuir.carrental.dao.model.user.User;
import com.bsuir.carrental.domain.dto.user.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    List<UserDto> toListDto(List<User> users);

    User toEntity(UserDto userDto);

}