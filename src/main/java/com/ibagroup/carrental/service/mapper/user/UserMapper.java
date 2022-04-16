package com.ibagroup.carrental.service.mapper.user;

import com.ibagroup.carrental.dao.model.user.User;
import com.ibagroup.carrental.service.dto.user.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    List<UserDto> toListDto(List<User> users);

    User toEntity(UserDto userDto);

}
